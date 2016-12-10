package lib.code.listener;

import java.awt.event.*;
import lib.code.panel.CodePanel;

public class CodeCentreMouseListener implements MouseListener
{
	CodePanel codePanel;
	
	public CodeCentreMouseListener(CodePanel codePanelInput)
	{
		codePanel = codePanelInput;
	}
	
	public void mouseClicked(MouseEvent e)
	{
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(codePanel.modifyPanel.getCheckModifyOperand())
		{
			codePanel.modifyPanel.changeDefaultOperandButton();
		}
		else if(codePanel.getCheckModify())
			codePanel.modifyPanel.invisiblePanel();
	}
	
	public void mouseReleased(MouseEvent e)
	{
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}
	
	public void mouseExited(MouseEvent e)
	{
	}
}
