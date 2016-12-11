package lib.code.renderer;

import java.awt.*;

import javax.swing.*;

import lib.code.CodeObject;

public class CodeRenderer extends DefaultListCellRenderer
{
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		CodeObject entry = (CodeObject) value;
			
		JPanel pnCode = new JPanel();
		pnCode.setOpaque(true);
		pnCode.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		if(list.isEnabled() == true)
		{
			if(isSelected)
				pnCode.setBackground(new Color(74,97,117));
			else
				pnCode.setBackground(Color.black);
		}
		else
		{
			if(isSelected)
				pnCode.setBackground(new Color(74,97,117));
			else
				pnCode.setBackground(Color.black);
		}
		pnCode.setForeground(Color.white);
		list.setBackground(Color.black);
		
		JLabel[] arrLabel = new JLabel[4];
		int i;
		
		arrLabel[0] = new JLabel();
		arrLabel[0].setText(entry.getName());
		
		arrLabel[1] = new JLabel();
		arrLabel[2] = new JLabel();
		arrLabel[3] = new JLabel();
		
		int target = entry.getTargetOperand();
		int dest = entry.getDestinationAddr();
		String comp = entry.getCompareOperand();
		
		if(comp != null)
			arrLabel[1].setText(entry.getCompareOperand());
		else
			arrLabel[1].setText("");
		
		if(target >= 0)
		{
			if(entry.isCheckedPointer() == true)
				arrLabel[2].setText("[" + entry.getTargetOperand() + "]");
			else
				arrLabel[2].setText(Integer.toString(entry.getTargetOperand()));
		}
		else
			arrLabel[2].setText("");
		
		if(dest >= 0)
			arrLabel[3].setText(Integer.toString(entry.getDestinationAddr()));
		else
			arrLabel[3].setText("");

		for(i=0; i<=3; i++)
		{
			arrLabel[i].setBackground(pnCode.getBackground());
			arrLabel[i].setForeground(pnCode.getForeground());
			pnCode.add(arrLabel[i]);
		}
		return pnCode;
	}
}
