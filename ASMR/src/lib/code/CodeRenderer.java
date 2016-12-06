package lib.code;

import java.awt.*;
import javax.swing.*;

public class CodeRenderer extends JLabel implements ListCellRenderer
{
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		CodeObject entry = (CodeObject) value;
		
		JPanel pnCode = new JPanel();
		pnCode.setOpaque(true);
		pnCode.setLayout(new FlowLayout(FlowLayout.LEFT));

		if(isSelected)
		{
			pnCode.setBackground(list.getSelectionBackground());
			pnCode.setForeground(list.getSelectionForeground());
		}
		else
		{
			pnCode.setBackground(list.getBackground());
			pnCode.setForeground(list.getForeground());
		}
		
		JLabel[] arrLabel = new JLabel[4];
		int i;
		
		arrLabel[0] = new JLabel();
		arrLabel[0].setText(entry.getName());
		
		for(i=1; i<=3; i++)
			arrLabel[i] = entry.lblOperand[i-1];
		
		for(i=0; i<=3; i++)
		{
			arrLabel[i].setBackground(pnCode.getBackground());
			arrLabel[i].setForeground(pnCode.getForeground());
			pnCode.add(arrLabel[i]);
		}
		
		return pnCode;
	}
}
