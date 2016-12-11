package lib.code.panel;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

import lib.code.CodeManager;
import lib.code.CodeObject;
import lib.code.listener.CodeCentreMouseListener;
import lib.code.listener.CodeLineMouseListener;
import lib.code.renderer.CodeRenderer;
import lib.variable.VariableManager;
import lib.variable.VariablePanel;

public class CodePanel extends JPanel implements AdjustmentListener, MouseListener
{
	public CodeModifyPanel modifyPanel;
	public VariablePanel variablePanel;
	private boolean checkModify = false;
	public CodeSourcePanel codeSourcePanel;
	public CodeDebugPanel pnDebug;
	JLayeredPane pnHiddenMain;
	public JScrollPane spMain;
	JScrollPane spLine;
	public DefaultListModel<CodeObject> listModelMain;
	DefaultListModel<String> listModelLine;
	public JList<CodeObject> listMain;
	public JList<String> listLine;
	JList<CodeObject> listCode;
	CodeListHandler lh;
	public CodeManager cm;
	
	public CodePanel(int x, int y, int w, int h, VariablePanel variablePanelInput)
	{
		System.out.println("Create CodePanel");
		this.setBounds(x, y, w, h);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		variablePanel = variablePanelInput;
		
		pnHiddenMain = new JLayeredPane();
		pnHiddenMain.setBounds(20, 0, w-20, h-35);
		pnHiddenMain.setBorder(null);
		pnHiddenMain.setLayout(null);
		this.add(pnHiddenMain);
		
		spMain = new JScrollPane();
		spMain.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spMain.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
		spMain.setBounds(0, 0, w-20, h-35);
		//spMain.setBorder(null);
		spMain.setBorder(BorderFactory.createMatteBorder(3, 0, 3, 3, Color.white));
		spMain.getVerticalScrollBar().addAdjustmentListener(this);
		spMain.getVerticalScrollBar().addMouseListener(new MouseAdapter()
		{
			 @Override
		    public void mousePressed(MouseEvent e)
			{
				 if(checkModify)
				{
					modifyPanel.changeDefaultOperandButton();
					modifyPanel.invisiblePanel();
				}
		    }
		});
		pnHiddenMain.add(spMain, JLayeredPane.DEFAULT_LAYER);
		
		spLine = new JScrollPane();
		spLine.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		spLine.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spLine.setBounds(0, 0, 20, h-35);
		spLine.setBorder(null);
		spLine.setBorder(BorderFactory.createMatteBorder(3, 0, 3, 0, Color.white));
		spLine.setOpaque(false);
		this.add(spLine);
		
		listMain = new JList<CodeObject>();
		listMain.setCellRenderer(new CodeRenderer());
		listMain.setDropMode(DropMode.INSERT);
		listMain.setDragEnabled(true);
		listMain.setBackground(Color.black);
		listMain.setForeground(Color.white);
		listMain.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		listMain.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lh = new CodeListHandler();
		listMain.setTransferHandler(lh);
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
		listLine.setBackground(new Color(232, 232, 232));
		listLine.setForeground(Color.white);
		listLine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLine.addMouseListener(new CodeLineMouseListener(this));
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
		
		/*
		for(int i=2; i<=17; i++)
			listModelLine.addElement(Integer.toString(i));
			*/
		
		listLine.setModel(listModelLine);
		
		listModelMain = new DefaultListModel<CodeObject>();
		listModelMain.addElement(new CodeObject());
		
		/*
		for(int i=1; i<=14; i++)
			listModelMain.addElement(new PrintData(false, new VariableManager(1)));
		listModelMain.addElement(new PrintData(false, new VariableManager(1)));
		listModelMain.addElement(new ScanData(false, new VariableManager(1)));
		listModelMain.addElement(new CopyFrom(false, new VariableManager(1), 1, false));
		*/
		
		listMain.setModel(listModelMain);
		
		modifyPanel = new CodeModifyPanel(this, variablePanel);
		modifyPanel.setVisible(false);
		pnHiddenMain.add(modifyPanel, JLayeredPane.POPUP_LAYER);
		
		cm = new CodeManager(listMain, variablePanel, this);
		
		pnDebug = new CodeDebugPanel(cm, this);
		this.add(pnDebug);
	}
	
	public boolean getCheckModify()
	{
		return checkModify;
	}
	
	public void setCheckModify(boolean input)
	{
		checkModify = input;
		if(checkModify == true)
			spMain.setWheelScrollingEnabled(false);
		else
			spMain.setWheelScrollingEnabled(true);
			
	}
	
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		BoundedRangeModel model = spMain.getVerticalScrollBar().getModel();
		spLine.getVerticalScrollBar().setModel(model);
	}
	
	public class CodeListHandler extends TransferHandler
	{
		JList listOrigin;
		CodeObject objOrigin;
	    private int origin = -1;
	    private int index = -1;
	            
	    /**
	     * 마우스가 드래그 되고 있을 때 1픽셀씩 움직일때마다 canImport 함수가 실행된다. 
	     */
	    public boolean canImport(TransferHandler.TransferSupport info)
	    {
	        if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
	            return false;
	        }
	        
	        JList listTemp = (JList) info.getComponent();
	        if(listTemp.getDropMode() == DropMode.USE_SELECTION)
	        	return false;
	        
	        JList.DropLocation dl = (JList.DropLocation) info.getDropLocation();
	        if(dl.getIndex() == listModelMain.getSize())
        		return false;

	        return true;
	    }

	    /**
	     * 마우스를 드래그하다가 마우스 버튼을 딱! 놨을때 실행
	     */
	    public boolean importData(TransferHandler.TransferSupport info)
	    {
	        listOrigin = (JList)info.getComponent();
	        origin = listOrigin.getSelectedIndex();
	        
	        /*
	        try {
	            String data = (String)info.getTransferable().getTransferData(DataFlavor.stringFlavor);
	        } catch (UnsupportedFlavorException ufe) {
	            System.out.println("importData: unsupported data flavor");
	            return false;
	        } catch (IOException ioe) {
	            System.out.println("importData: I/O exception");
	            return false;
	        }*/
	        
	        JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
	        index = dl.getIndex();
	        
	        if(objOrigin.getDefaultObject() == false)
	        {
		        if(origin+1 != index && origin != index)
		        {
		        	listModelMain.add(index, (CodeObject) listOrigin.getSelectedValue());
		        }
		        else
		        	return false;
	        }
	        else
	        {
	        	CodeObject objTemp = objOrigin.copy();
	        	
	        	objTemp.setDefaultObject(false);
	        	listModelMain.add(index, objTemp);
	        	listOrigin.setSelectedIndex(index);
	        	listModelLine.addElement(Integer.toString(listModelLine.getSize()+1));
	        	listMain.clearSelection();
	        	codeSourcePanel.clear();
	        	
	        	return false;
	        }
	        return true;
	        //System.out.println(objTemp.getDefaultObject());
	        //return false;
	    }
	    
	    protected Transferable createTransferable(JComponent c)
	    {
	    	/*
	    	//StringSelection을 하면 드래그하면서 위치가 표시되는데.. 
	    	//밑에 있는 getSourceActions도 써야 표시됨.
	        return new StringSelection("");
	        */
	    	
	    	JList listTemp = (JList) c;
	    	objOrigin = (CodeObject) listTemp.getSelectedValue();
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
	    		listOrigin.setSelectedIndex(index);
	    		
	    		if(origin > index)
	    			origin++;
	    		listModelMain.remove(origin);
	    		listMain.clearSelection();
	    	}
	    }
	}
	
	public void mouseClicked(MouseEvent e)
	{
	}
	
	public void mousePressed(MouseEvent e)
	{
		CodeObject temp = listMain.getSelectedValue();
		if(temp != null)
		{
			if(temp.getName() != null)
			{
				if(checkModify)
				{
					modifyPanel.changeDefaultOperandButton();
					modifyPanel.invisiblePanel();
				}
			}
			else
			{
				modifyPanel.changeDefaultOperandButton();
				modifyPanel.invisiblePanel();
			}
		}
	}
	
	public void mouseReleased(MouseEvent e)
	{
		CodeObject temp = listMain.getSelectedValue();
		if(temp != null)
		{
			if(temp.getName() != null)
			{
				if(checkModify == false)
				{
					setCheckModify(true);
					int selectedIndex = listMain.getSelectedIndex();
					if(selectedIndex != -1)
					{
						Rectangle bounds = listMain.getCellBounds(selectedIndex, selectedIndex);
						bounds = new Rectangle(bounds.x, bounds.y-spMain.getVerticalScrollBar().getModel().getValue(), bounds.width, bounds.height);
						modifyPanel.setBoundsPanel(bounds);
						modifyPanel.setCode(listMain.getSelectedValue());
						modifyPanel.setVisible(true);
					}
					codeSourcePanel.clear();
				}
			}
		}
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}
	
	public void mouseExited(MouseEvent e)
	{
	}
	
	public JPanel createCodeSourcePanel(int w, int heightDefault, int heightSize, int avCmInput, VariableManager vm, boolean availablePointer)
	{
		Rectangle bounds = this.getBounds();
		codeSourcePanel = new CodeSourcePanel(bounds.x-w, bounds.y, w, heightDefault, heightSize, avCmInput, vm, availablePointer, lh, this);
		return codeSourcePanel;
	}
}
