package lib.code;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.*;

import lib.code.CodeConstants;
import lib.code.CodePanel.CodeListHandler;
import lib.code.instruction.*;
import lib.variable.VariableManager;

public class CodeSourcePanel extends JPanel implements CodeConstants
{
	CodeCreateDefaultObject objCreateCode;
	int availableCommand;
	JList<CodeObject> listCode;
	DefaultListModel<CodeObject> listModelCode;
	CodeListHandler lh;
	
	public CodeSourcePanel(int x, int y, int w, int heightDefault, int heightSize, int avCmInput, VariableManager vmInput, boolean availablePointer, CodeListHandler lh2)
	{
		lh = lh2;
		objCreateCode = new CodeCreateDefaultObject(vmInput, availablePointer);
		availableCommand = (1<<avCmInput)-1;

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
		this.setLayout(null);
		
		listCode = new JList<CodeObject>();
		listCode.setBounds(0, 0, w, h);
		listCode.setCellRenderer(new CodeSourceRenderer());
		listCode.setDropMode(DropMode.USE_SELECTION);
		listCode.setDragEnabled(true);
		listCode.setFixedCellHeight(heightSize);
		listCode.setTransferHandler(lh);
		//listCode.addMouseListener(this);
		this.add(listCode);
		
		listModelCode = new DefaultListModel<CodeObject>();
		listCode.setModel(listModelCode);
		createCodeElement();
	}
	
	public void createCodeElement()
	{
		System.out.println("Create codeElement");
		if(isDataAvailableCommand(availableCommand, CODE_SCANDATA))
			listModelCode.addElement(objCreateCode.createScanData());
		if(isDataAvailableCommand(availableCommand, CODE_PRINTDATA))
			listModelCode.addElement(objCreateCode.createPrintData());
		if(isDataAvailableCommand(availableCommand, CODE_COPYFROM))
			listModelCode.addElement(objCreateCode.createCopyFrom());
	}
	
	public boolean isDataAvailableCommand(int avCo, int input)
	{
		if((avCo & input) != 0)
			return true;
		else
			return false;
	}
}