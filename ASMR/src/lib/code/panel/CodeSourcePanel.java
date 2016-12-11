package lib.code.panel;

import java.awt.Color;

import javax.swing.*;

import lib.code.CodeConstants;
import lib.code.CodeCreateDefaultObject;
import lib.code.CodeObject;
import lib.code.listener.CodeCentreMouseListener;
import lib.code.panel.CodePanel.CodeListHandler;
import lib.code.renderer.CodeSourceRenderer;
import lib.variable.VariableManager;

public class CodeSourcePanel extends JPanel implements CodeConstants
{
	CodePanel codePanel;
	CodeCreateDefaultObject objCreateCode;
	int availableCommand;
	JList<CodeObject> listCode;
	DefaultListModel<CodeObject> listModelCode;
	CodeListHandler lh;

	public CodeSourcePanel(int x, int y, int w, int heightDefault, int heightSize, int avCmInput, VariableManager vmInput, boolean availablePointer, CodeListHandler lhInput, CodePanel codePanelInput)
	{
		codePanel = codePanelInput;
		lh = lhInput;
		objCreateCode = new CodeCreateDefaultObject(codePanel.cm, vmInput, availablePointer);
		availableCommand = avCmInput;

		int temp = 0;
		
		for(int i=0; i<CODE_MAXSIZE; i++)
		{
			if(isDataAvailableCommand(availableCommand, 1<<i))
				temp++;
		}
		
		//System.out.println(availableCommand);
		
		int h = heightSize*temp+heightDefault;
		
		System.out.println("Create CodeSourcePanel");
		this.setBounds(x, y, w, h);
		this.setOpaque(true);
		this.setBackground(Color.black);
		this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 0, Color.white));
		this.setLayout(null);
		
		listCode = new JList<CodeObject>();
		listCode.setBounds(3, 3, w-3, h-6);
		listCode.setCellRenderer(new CodeSourceRenderer());
		listCode.setDropMode(DropMode.USE_SELECTION);
		listCode.setDragEnabled(true);
		listCode.setFixedCellHeight(heightSize);
		listCode.setTransferHandler(lh);
		listCode.setBackground(Color.black);
		listCode.setForeground(Color.white);
		listCode.addMouseListener(new CodeCentreMouseListener(codePanel));
		this.add(listCode);
		
		listModelCode = new DefaultListModel<CodeObject>();
		listCode.setModel(listModelCode);
		createCodeElement();
	}
	
	public void clear()
	{
		listCode.clearSelection();
	}
	
	public void createCodeElement()
	{
		System.out.println("Create codeElement");
		if(isDataAvailableCommand(availableCommand, CODE_SCANDATA))
			listModelCode.addElement(objCreateCode.createScanData());
		if(isDataAvailableCommand(availableCommand, CODE_PRINTDATA))
			listModelCode.addElement(objCreateCode.createPrintData());
		if(isDataAvailableCommand(availableCommand, CODE_COPYTO))
			listModelCode.addElement(objCreateCode.createCopyTo());
		if(isDataAvailableCommand(availableCommand, CODE_COPYFROM))
			listModelCode.addElement(objCreateCode.createCopyFrom());
		if(isDataAvailableCommand(availableCommand, CODE_INC))
			listModelCode.addElement(objCreateCode.createInc());
		if(isDataAvailableCommand(availableCommand, CODE_DEC))
			listModelCode.addElement(objCreateCode.createDec());
		if(isDataAvailableCommand(availableCommand, CODE_ADD))
			listModelCode.addElement(objCreateCode.createAdd());
		if(isDataAvailableCommand(availableCommand, CODE_SUB))
			listModelCode.addElement(objCreateCode.createSub());
		if(isDataAvailableCommand(availableCommand, CODE_IFCPU))
			listModelCode.addElement(objCreateCode.createIfCpu());
		if(isDataAvailableCommand(availableCommand, CODE_JUMP))
			listModelCode.addElement(objCreateCode.createJump());
	}
	
	public boolean isDataAvailableCommand(int avCo, int input)
	{
		if((avCo & input) != 0)
			return true;
		else
			return false;
	}
}