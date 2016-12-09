package lib.code;

import java.awt.*;

import javax.swing.*;

public class CodeModifyPanel extends JPanel
{
	CodeObject targetCode;
	int opTarget;
	String opCompare;
	int opDestination;
	JLabel[] lblModify;
	
	public CodeModifyPanel()
	{
		System.out.println("Create CodeModifyPanel");
		this.setOpaque(true);
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		lblModify = new JLabel[4];
		
		for(int i=0; i<=3; i++)
		{
			lblModify[i] = new JLabel("");
			lblModify[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			this.setOpaque(true);
			this.add(lblModify[i]);
		}
	}
	
	public void setBoundsPanel(Rectangle bounds)
	{
		this.setBounds(bounds.x, bounds.y-5, bounds.width, bounds.height+10);
	}
	
	public void setCode(CodeObject targetCode)
	{
		opCompare = targetCode.getCompareOperand();
		opTarget = targetCode.getTargetOperand();
		opDestination = targetCode.getDestinationAddr();
		
		lblModify[0].setText(targetCode.getName());
		lblModify[1].setText(targetCode.lblOperand[0].getText());
		lblModify[2].setText(targetCode.lblOperand[1].getText());
		lblModify[3].setText(targetCode.lblOperand[2].getText());
	}
}
