package lib.code;

import java.awt.*;

import javax.swing.*;

public class CodeSourceRenderer extends JLabel implements ListCellRenderer
{
	public CodeSourceRenderer()
	{
		System.out.println("Create CodeSourceRenderer");
		this.setOpaque(true);
	}
	
	public int getHorizontalAlignment()
	{
		//System.out.println(getBounds());
		return RIGHT;
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		CodeObject entry = (CodeObject) value;
		
		if(isSelected)
		{
			this.setBackground(list.getSelectionBackground());
			this.setForeground(list.getSelectionForeground());
		}
		else
		{
			this.setBackground(list.getBackground());
			this.setForeground(list.getForeground());
		}

		this.setText(entry.getName());
		
		return this;
	}
}
