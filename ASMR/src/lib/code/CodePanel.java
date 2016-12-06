package lib.code;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;
import lib.code.instruction.*;
import lib.variable.VariableManager;

public class CodePanel extends JPanel implements AdjustmentListener, MouseListener
{
	VariableManager vm;
	JLayeredPane pnHiddenMain;
	JScrollPane spMain;
	JScrollPane spLine;
	JLabel tested = new JLabel("안녕하세요!");
	DefaultListModel<CodeObject> listModelMain;
	DefaultListModel<String> listModelLine;
	JList<CodeObject> listMain;
	JList<String> listLine;
	
	public CodePanel(VariableManager vmInput, int x, int y, int w, int h)
	{
		vm = vmInput;
		
		System.out.println("Create");
		this.setBounds(x, y, w, h);
		this.setLayout(null);
		
		pnHiddenMain = new JLayeredPane();
		pnHiddenMain.setBounds(20, 0, w-20, h);
		pnHiddenMain.setBorder(null);
		pnHiddenMain.setLayout(null);
		this.add(pnHiddenMain);
		
		spMain = new JScrollPane();
		spMain.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spMain.setBounds(0, 0, w-20, h);
		spMain.setBorder(null);
		spMain.getVerticalScrollBar().addAdjustmentListener(this);
		pnHiddenMain.add(spMain, 1);
		
		spLine = new JScrollPane();
		spLine.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		spLine.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spLine.setBounds(0, 0, 20, h);
		spLine.setBorder(null);
		spLine.setOpaque(false);
		this.add(spLine);
		
		listMain = new JList<CodeObject>();
		listMain.setCellRenderer(new CodeRenderer());
		listMain.setDropMode(DropMode.INSERT);
		listMain.setDragEnabled(true);
		listMain.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		listMain.setTransferHandler(new ListTransferHandler());
		listMain.setFixedCellHeight(30);
		listMain.addMouseListener(this);
		spMain.add(listMain);
		spMain.setViewportView(listMain);
		
		listLine = new JList<String>();
		listLine.setEnabled(false);
		listLine.setDropMode(DropMode.INSERT);
		listLine.setDragEnabled(true);
		listLine.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		listLine.setFixedCellHeight(30);
		listLine.addMouseListener(this);
		listLine.setCellRenderer(new DefaultListCellRenderer()
		{
			public int getHorizontalAlignment()
			{
				//System.out.println(getBounds());
				return RIGHT;
			}
		});
		spLine.add(listLine);
		spLine.setViewportView(listLine);
		
		listModelLine = new DefaultListModel<String>();
		listModelLine.addElement("1");
		
		for(int i=2; i<=17; i++)
			listModelLine.addElement(Integer.toString(i));
		
		listLine.setModel(listModelLine);
		
		listModelMain = new DefaultListModel<CodeObject>();
		
		for(int i=1; i<=14; i++)
			listModelMain.addElement(new PrintData(new VariableManager(1)));
		listModelMain.addElement(new PrintData(new VariableManager(1)));
		listModelMain.addElement(new ScanData(new VariableManager(1)));
		listModelMain.addElement(new CopyFrom(new VariableManager(1), 1, false));
		
		listMain.setModel(listModelMain);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		BoundedRangeModel model = spMain.getVerticalScrollBar().getModel();
		spLine.getVerticalScrollBar().setModel(model);
	}
	
	public class ListTransferHandler extends TransferHandler
	{
		JList list;
	    private int origin = -1;
	    private int index = -1;
	            
	    /**
	     * 마우스가 드래그 되고 있을 때 1픽셀씩 움직일때마다 canImport 함수가 실행된다. 
	     */
	    public boolean canImport(TransferHandler.TransferSupport info)
	    {
	        // Check for String flavor
	        if (!info.isDataFlavorSupported(DataFlavor.stringFlavor))
	        {
	            return false;
	        }
	        return true;
	    }

	    /**
	     * 마우스를 드래그하다가 마우스 버튼을 딱! 놨을때 실행
	     */
	    public boolean importData(TransferHandler.TransferSupport info)
	    {
	        if (!info.isDrop())
	        {
	            return false;
	        }

	        list = (JList)info.getComponent();
	        origin = list.getSelectedIndex();
	        
	        JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
	        index = dl.getIndex();
	        
	        if(origin+1 != index && origin != index)
	        	listModelMain.add(index, (CodeObject) list.getSelectedValue());
	        else
	        	return false;

	        return true;
	    }
	    
	    protected Transferable createTransferable(JComponent c)
	    {
	    	//StringSelection을 하면 드래그하면서 위치가 표시되는데.. 
	    	//밑에 있는 getSourceActions도 써야 표시됨.
	        return new StringSelection("");
	    }
	    
	    public int getSourceActions(JComponent c)
	    {
	        return TransferHandler.MOVE;
	    }
	    
	    protected void exportDone(JComponent c, Transferable data, int action)
	    {
	    	//정상적인 리스트안의 이동이여야함!
	    	if (action == TransferHandler.MOVE) 
	    	{
	    		list.setSelectedIndex(index);
	    		
	    		if(origin > index)
	    			origin++;
	    		listModelMain.remove(origin);
	    	}
	    }
	}
	
	public void mouseClicked(MouseEvent e)
	{
	}
	
	public void mousePressed(MouseEvent e)
	{
		tested.setVisible(false);
	}
	
	public void mouseReleased(MouseEvent e)
	{
		System.out.println("Release!");
		int selectedIndex = listMain.getSelectedIndex();
		Rectangle bounds = listMain.getCellBounds(selectedIndex, selectedIndex);
		System.out.println(bounds);

		tested.setVisible(true);
		tested.setBounds(bounds.x, bounds.y-10, bounds.width, bounds.height+20);
		tested.setOpaque(true);
		tested.setBackground(Color.RED);
		pnHiddenMain.add(tested, 0);
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}
	
	public void mouseExited(MouseEvent e)
	{
	}
}
