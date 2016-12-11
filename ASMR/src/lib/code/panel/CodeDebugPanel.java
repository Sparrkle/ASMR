package lib.code.panel;

import java.awt.*;

import javax.swing.*;

import lib.code.CodeManager;
import lib.code.listener.CodeDebugActionListener;

public class CodeDebugPanel extends JPanel
{
	CodePanel cp;
	CodeManager cm;
	JButton btnStop;
	JButton btnBack;
	JButton btnStart;
	JButton btnFront;
	JButton btnSpeedDown;
	JButton btnSpeedUp;
	
	ImageIcon imgStop = new ImageIcon("src/img/btnStop.png");
	ImageIcon imgBack = new ImageIcon("src/img/btnBack.png");
	ImageIcon imgStart = new ImageIcon("src/img/btnPlay.png");
	ImageIcon imgFront = new ImageIcon("src/img/btnFront.png");
	ImageIcon imgSpeedDown = new ImageIcon("src/img/btnSpeedDown.png");
	ImageIcon imgSpeedUp = new ImageIcon("src/img/btnSpeedUp.png");
	ImageIcon imgStopDisabled = new ImageIcon("src/img/btnStopDisabled.png");
	ImageIcon imgBackDisabled = new ImageIcon("src/img/btnBackDisabled.png");
	ImageIcon imgStartDisabled = new ImageIcon("src/img/btnPlayDisabled.png");
	ImageIcon imgFrontDisabled = new ImageIcon("src/img/btnFrontDisabled.png");
	ImageIcon imgSpeedDownDisabled = new ImageIcon("src/img/btnSpeedDownDisabled.png");
	ImageIcon imgSpeedUpDisabled = new ImageIcon("src/img/btnSpeedUpDisabled.png");
	
	public CodeDebugPanel(CodeManager cmInput, CodePanel cpInput)
	{
		System.out.println("Created CodeDebugPanel");
		
		cp = cpInput;
		cm = cmInput;
		
		this.setOpaque(false);
		this.setBounds(0, 385, 220, 30);
		this.setLayout(new GridLayout(1, 6, 8, 0));
		
		btnStop = new JButton("");
		btnStop.setActionCommand("Stop");
		btnStop.setBounds(0, 415, 30, 30);
		btnStop.setContentAreaFilled(false);
		btnStop.setRequestFocusEnabled(false);
		btnStop.addActionListener(new CodeDebugActionListener(cm, cp));
		btnStop.setIcon(imgStop);
		btnStop.setDisabledIcon(imgStopDisabled);
		this.add(btnStop);
		
		btnBack = new JButton("");
		btnBack.setActionCommand("Back");
		btnBack.setBounds(0, 415, 30, 30);
		btnBack.setContentAreaFilled(false);
		btnBack.setRequestFocusEnabled(false);
		btnBack.addActionListener(new CodeDebugActionListener(cm, cp));
		btnBack.setIcon(imgBack);
		btnBack.setDisabledIcon(imgBackDisabled);
		this.add(btnBack);
		
		btnStart = new JButton("");
		btnStart.setActionCommand("Start");
		btnStart.setBounds(0, 415, 30, 30);
		btnStart.setContentAreaFilled(false);
		btnStart.setRequestFocusEnabled(false);
		btnStart.addActionListener(new CodeDebugActionListener(cm, cp));
		btnStart.setIcon(imgStart);
		btnStart.setDisabledIcon(imgStartDisabled);
		this.add(btnStart);
		
		btnFront = new JButton("");
		btnFront.setActionCommand("Front");
		btnFront.setBounds(0, 415, 30, 30);
		btnFront.setContentAreaFilled(false);
		btnFront.setRequestFocusEnabled(false);
		btnFront.addActionListener(new CodeDebugActionListener(cm, cp));
		btnFront.setIcon(imgFront);
		btnFront.setDisabledIcon(imgFrontDisabled);
		this.add(btnFront);
		
		btnSpeedDown = new JButton("");
		btnSpeedDown.setActionCommand("SpeedDown");
		btnSpeedDown.setBounds(0, 415, 30, 30);
		btnSpeedDown.setContentAreaFilled(false);
		btnSpeedDown.setRequestFocusEnabled(false);
		btnSpeedDown.setEnabled(false);
		btnSpeedDown.addActionListener(new CodeDebugActionListener(cm, cp));
		btnSpeedDown.setIcon(imgSpeedDown);
		btnSpeedDown.setDisabledIcon(imgSpeedDownDisabled);
		this.add(btnSpeedDown);
		
		btnSpeedUp = new JButton("");
		btnSpeedUp.setActionCommand("SpeedUp");
		btnSpeedUp.setBounds(0, 415, 30, 30);
		btnSpeedUp.setContentAreaFilled(false);
		btnSpeedUp.setRequestFocusEnabled(false);
		btnSpeedUp.addActionListener(new CodeDebugActionListener(cm, cp));
		btnSpeedUp.setIcon(imgSpeedUp);
		btnSpeedUp.setDisabledIcon(imgSpeedUpDisabled);
		this.add(btnSpeedUp);
	}
	
	public void setBtnSpeedDownEnabled(boolean input)
	{
		btnSpeedDown.setEnabled(input);
	}
	
	public void setBtnSpeedUpEnabled(boolean input)
	{
		btnSpeedUp.setEnabled(input);
	}
	
	public void setBtnStopEnabled(boolean input)
	{
		btnStop.setEnabled(input);
	}
	
	public void setBtnBackEnabled(boolean input)
	{
		btnBack.setEnabled(input);
	}
	
	public void setBtnFrontGroupEnabled(boolean input)
	{
		btnStart.setEnabled(input);
		btnFront.setEnabled(input);
	}
}
