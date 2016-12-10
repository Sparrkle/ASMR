package lib.code.panel;

import java.awt.*;

import javax.swing.*;

import lib.code.CodeManager;

public class CodeDebugPanel extends JPanel
{
	CodeManager cm;
	JButton btnStop;
	JButton btnBack;
	JButton btnStart;
	JButton btnFront;
	JButton btnSpeedDown;
	JButton btnSpeedUp;
	
	public CodeDebugPanel(CodeManager cmInput)
	{
		cm = cmInput;
		
		this.setOpaque(false);
		this.setBounds(0, 385, 220, 30);
		this.setLayout(new GridLayout(1, 6, 8, 0));
		
		btnStop = new JButton("");
		btnStop.setActionCommand("Stop");
		btnStop.setBounds(0, 415, 30, 30);
		btnStop.setContentAreaFilled(false);
		btnStop.setRequestFocusEnabled(false);
		this.add(btnStop);
		
		btnBack = new JButton("");
		btnBack.setActionCommand("Back");
		btnBack.setBounds(0, 415, 30, 30);
		btnBack.setContentAreaFilled(false);
		btnBack.setRequestFocusEnabled(false);
		this.add(btnBack);
		
		btnStart = new JButton("");
		btnStart.setActionCommand("Start");
		btnStart.setBounds(0, 415, 30, 30);
		btnStart.setContentAreaFilled(false);
		btnStart.setRequestFocusEnabled(false);
		this.add(btnStart);
		
		btnFront = new JButton("");
		btnFront.setActionCommand("Front");
		btnFront.setBounds(0, 415, 30, 30);
		btnFront.setContentAreaFilled(false);
		btnFront.setRequestFocusEnabled(false);
		this.add(btnFront);
		
		btnSpeedDown = new JButton("");
		btnSpeedDown.setActionCommand("SpeedDown");
		btnSpeedDown.setBounds(0, 415, 30, 30);
		btnSpeedDown.setContentAreaFilled(false);
		btnSpeedDown.setRequestFocusEnabled(false);
		this.add(btnSpeedDown);
		
		btnSpeedUp = new JButton("");
		btnSpeedUp.setActionCommand("SpeedUp");
		btnSpeedUp.setBounds(0, 415, 30, 30);
		btnSpeedUp.setContentAreaFilled(false);
		btnSpeedUp.setRequestFocusEnabled(false);
		this.add(btnSpeedUp);
	}
}
