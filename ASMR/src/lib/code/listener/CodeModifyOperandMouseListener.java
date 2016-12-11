package lib.code.listener;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import lib.code.CodeObject;
import lib.code.panel.CodeModifyPanel;

public class CodeModifyOperandMouseListener extends MouseAdapter
{
	CodeModifyPanel codeModifyPanel;
	int operandNumber;
	
	public CodeModifyOperandMouseListener(CodeModifyPanel codeModifyPanelInput, int inputNum)
	{
		codeModifyPanel = codeModifyPanelInput;
		operandNumber = inputNum;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(operandNumber == 1)
		{
			if(codeModifyPanel.getCheckModifyOperand() == true)
			{
				if(codeModifyPanel.pnOperand[operandNumber-1].getBackground() != Color.orange)
					codeModifyPanel.changeDefaultOperandButton();
				else
					compareEvent();
			}
			else
			{
				compareEvent();
			}
		}
		else if(operandNumber == 2)
		{
			if(SwingUtilities.isLeftMouseButton(e))
			{
				if(codeModifyPanel.getCheckModifyOperand() == true)
					codeModifyPanel.changeDefaultOperandButton();
				else
				{
					codeModifyPanel.highlightOperandPanel(operandNumber, Color.orange);
					codeModifyPanel.highlightVariableButton(Color.orange);
				}
			}
			else if(SwingUtilities.isRightMouseButton(e))
			{
				CodeObject targetCode = codeModifyPanel.getTargetCode();
				boolean avPo = targetCode.isAvailablePointer();
				if(avPo == true)
				{
					if(targetCode.isCheckedPointer() == true)
						targetCode.setCheckedPointer(false);
					else
						targetCode.setCheckedPointer(true);
					codeModifyPanel.setTargetText();
				}
			}
		}
		else if(operandNumber == 3)
		{
			if(codeModifyPanel.getCheckModifyOperand() == true)
				codeModifyPanel.changeDefaultOperandButton();
			else
			{
				codeModifyPanel.highlightListLine(new Color(251, 113, 0), true);
				codeModifyPanel.highlightOperandPanel(operandNumber, Color.orange);
			}
		}
		codeModifyPanel.setSelectedOperand(operandNumber);
    }
	
	public void compareEvent()
	{
		CodeObject targetCode = codeModifyPanel.getTargetCode();
		String compare = targetCode.getCompareOperand(); 
		if(compare.equals(">="))
			targetCode.setCompareOperand(">");
		else if(compare.equals(">"))
			targetCode.setCompareOperand("==");
		else if(compare.equals("=="))
			targetCode.setCompareOperand("<");
		else if(compare.equals("<"))
			targetCode.setCompareOperand("<=");
		else if(compare.equals("<="))
			targetCode.setCompareOperand(">=");
		codeModifyPanel.highlightOperandPanel(operandNumber, Color.orange);
		codeModifyPanel.setCompareText();
	}
}
