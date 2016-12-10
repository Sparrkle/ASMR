package lib.code.listener;

import java.awt.event.*;

import lib.code.panel.CodePanel;

public class CodeVariableMouseListener extends CodeCentreMouseListener
{
	int num;

	public CodeVariableMouseListener(CodePanel codePanelInput, int numInput)
	{
		super(codePanelInput);
		num = numInput;
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if(codePanel.getCheckModify())
		{
			if(codePanel.modifyPanel.getCheckModifyOperand())
			{
				if(num >= 0)
				{
					codePanel.modifyPanel.changeDefaultOperandButton();
					codePanel.modifyPanel.updateTargetCode(num);
				}
				else
					codePanel.modifyPanel.invisiblePanel();
			}
			else
				codePanel.modifyPanel.invisiblePanel();
		}
	}
}
