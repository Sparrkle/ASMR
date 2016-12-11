package lib.code.panel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import lib.code.CodeObject;
import lib.code.listener.CodeModifyOperandMouseListener;
import lib.variable.VariablePanel;

public class CodeModifyPanel extends JPanel implements MouseListener
{
	VariablePanel variablePanel;
	CodePanel codePanel; 
	
	public JPanel[] pnOperand;
	JLabel[] lblModify;
	CodeObject targetCode;
	boolean checkModifyOperand;
	int selectedOperand = 1;
	
	public CodeModifyPanel(CodePanel codePanelInput, VariablePanel variablePanelInput)
	{
		System.out.println("Create CodeModifyPanel");
		
		this.setOpaque(true);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.addMouseListener(this);
		
		this.setBackground(new Color(124, 148 ,169));
		
		variablePanel = variablePanelInput;
		codePanel = codePanelInput;
		
		lblModify = new JLabel[4];
		pnOperand = new JPanel[3];
		
		for(int i=0; i<=3; i++)
		{
			lblModify[i] = new JLabel("");
			lblModify[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			
			if(i>0)
			{
				pnOperand[i-1] = new JPanel();
				pnOperand[i-1].add(lblModify[i]);
				pnOperand[i-1].setVisible(false);
				pnOperand[i-1].setBackground(new Color(164, 142 ,88));
				pnOperand[i-1].setForeground(Color.white);
				
				pnOperand[i-1].addMouseListener(new CodeModifyOperandMouseListener(this, i));
				this.add(pnOperand[i-1]);
			}
			else
				this.add(lblModify[i]);
		}
	}
	
	public CodeObject getTargetCode()
	{
		return targetCode;
	}
	
	public void updateDestinationCode(int input)
	{
		targetCode.setDestinationAddr(input);
		setDestinationText();
	}
	
	public void updateTargetCode(int input)
	{
		targetCode.setTargetOperand(input);
		setTargetText();
	}
	
	public void deletePaintGlitch()
	{
		// paint glitch를 없애기 위한 묘수
		this.setVisible(false);
		this.setVisible(true);
	}
	
	public void setBoundsPanel(Rectangle bounds)
	{
		this.setBounds(bounds.x, bounds.y, bounds.width, bounds.height+10);
	}
	
	public void setCode(CodeObject targetCodeInput)
	{
		checkModifyOperand = false;
		
		targetCode = targetCodeInput;
		
		/**
		 * lblModify[1] - 비교 operand
		 * lblModify[2] - 타겟 operand
		 * lblModify[3] - 라인 operand로 implied 정의함.
		 */
		int dest = targetCode.getDestinationAddr();
		String comp = targetCode.getCompareOperand();
		
		lblModify[0].setText(targetCode.getName());
		lblModify[1].setText(comp);
		setTargetText();
		lblModify[3].setText(Integer.toString(dest));

		for(int i=1; i<=3; i++)
		{
			if(lblModify[i].getText() == null || lblModify[i].getText().equals("-1"))
			{
				pnOperand[i-1].setVisible(false);
			}
			else
			{
				pnOperand[i-1].setVisible(true);
			}
		}
	}
	
	public void setCompareText()
	{
		lblModify[1].setText(targetCode.getCompareOperand());
		deletePaintGlitch();
	}
	
	public void setTargetText()
	{
		boolean checkedPointer = targetCode.isCheckedPointer();
		if(checkedPointer == true)
			lblModify[2].setText("[" + targetCode.getTargetOperand() + "]");
		else
			lblModify[2].setText(Integer.toString(targetCode.getTargetOperand()));
		deletePaintGlitch();
	}
	
	public void setDestinationText()
	{
		lblModify[3].setText(Integer.toString(targetCode.getDestinationAddr()));
		deletePaintGlitch();
	}
	
	public boolean getCheckModifyOperand()
	{
		return checkModifyOperand;
	}
	
	public void setCheckModifyOperand(boolean input)
	{
		checkModifyOperand = input;
	}

	public void mouseClicked(MouseEvent e)
	{
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(checkModifyOperand == false)
		{
			if(SwingUtilities.isRightMouseButton(e))
			{
				int selectedIndex = codePanel.listMain.getSelectedIndex();
				codePanel.listModelMain.remove(selectedIndex);
				codePanel.listModelLine.remove(codePanel.listLine.getModel().getSize()-1);
			}
			invisiblePanel();
		}
		else
			changeDefaultOperandButton();
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
	
	public void invisiblePanel()
	{
		this.setVisible(false);
		codePanel.setCheckModify(false);
		codePanel.listMain.clearSelection();
		codePanel.codeSourcePanel.clear();
		codePanel.listMain.repaint();
	}
	
	public void setSelectedOperand(int input)
	{
		selectedOperand = input; 
	}
	
	public void changeDefaultOperandButton()
	{
		highlightOperandPanel(selectedOperand, new Color(164, 142 ,88));
		if(selectedOperand == 2)
			highlightVariableButton(Color.WHITE);
		else if(selectedOperand == 3)
		{
			highlightListLine(Color.BLACK, false);
			codePanel.listLine.clearSelection();
		}
		codePanel.codeSourcePanel.clear();
		checkModifyOperand = false;
	}
	
	public void highlightOperandPanel(int num, Color colorInput)
	{
		pnOperand[num-1].setBackground(colorInput);
		checkModifyOperand = true;
	}
	
	public void highlightVariableButton(Color colorInput)
	{
		variablePanel.btnVariable[targetCode.getTargetOperand()].setBorder(new LineBorder(colorInput, 2));
	}
	
	public void highlightListLine(Color colorInput, boolean changeHighlight)
	{
		codePanel.listLine.setEnabled(changeHighlight);
		codePanel.listLine.setForeground(colorInput);
		//variablePanel.btnVariable[targetCode.getTargetOperand()].setBorder(new LineBorder(colorInput, 2));
	}
}
