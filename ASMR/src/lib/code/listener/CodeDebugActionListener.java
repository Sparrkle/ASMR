package lib.code.listener;

import java.awt.Color;
import java.awt.event.*;

import lib.code.CodeManager;
import lib.code.panel.CodePanel;

public class CodeDebugActionListener implements ActionListener
{
	CodePanel cp;
	CodeManager cm;
	
	public CodeDebugActionListener(CodeManager cmInput, CodePanel cpInput)
	{
		cp = cpInput;
		cm = cmInput;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(cp.getCheckModify())
		{
			if(cp.modifyPanel.getCheckModifyOperand())
			{
				cp.modifyPanel.changeDefaultOperandButton();
			}
			cp.modifyPanel.invisiblePanel();
		}
		
		if(ae.getActionCommand() == "Stop")
		{
			cm.stop();
			cm.setProgramCounter(-1);
			cm.vp.resetAll();
			cm.ch.clear();
			cp.listMain.setEnabled(true);
			cp.codeSourcePanel.setVisible(true);
			cp.listMain.addMouseListener(cp);
			cp.listMain.setBackground(Color.white);
			cp.listMain.clearSelection();
			cm.setOutputandClear();
		}
		else if(ae.getActionCommand() == "Back")
		{
			cm.stop();
			cm.codeBack();
		}
		else if(ae.getActionCommand() == "Start")
		{
			if(cp.listModelMain.getSize() > 1)
			{
				cp.listMain.setEnabled(false);
				cp.codeSourcePanel.setVisible(false);
				cp.listMain.removeMouseListener(cp);
				cp.listMain.setBackground(new Color(210, 210, 210));
				cm.start();
			}
		}
		else if(ae.getActionCommand() == "Front")
		{
			if(cp.listModelMain.getSize() > 1)
			{
				if(cp.codeSourcePanel.isVisible() == true)
					cm.setOutputandClear();
				cm.stop();
				cp.listMain.setEnabled(false);
				cp.codeSourcePanel.setVisible(false);
				cp.listMain.removeMouseListener(cp);
				cp.listMain.setBackground(new Color(210, 210, 210));
				cm.codeFront();
			}
		}
		else if(ae.getActionCommand() == "SpeedUp")
		{
			cm.setDelay(cm.getDelay()-320);
			if(cm.getDelay() <= 40)
				cp.pnDebug.setBtnSpeedUpEnabled(false);
			else
				cp.pnDebug.setBtnSpeedDownEnabled(true);
		}
		else if(ae.getActionCommand() == "SpeedDown")
		{
			cm.setDelay(cm.getDelay()+320);
			if(cm.getDelay() >= 1000)
				cp.pnDebug.setBtnSpeedDownEnabled(false);
			else
				cp.pnDebug.setBtnSpeedUpEnabled(true);
		}
	}
}
