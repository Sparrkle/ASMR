package lib;

import java.awt.*;
import javax.swing.*;

import window.LoginScreen;

public class ASMRMain extends JFrame
{
	public ASMRMain(String title)
	{
		this.setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(720, 480);
		Container ctLogin = getContentPane();
		ctLogin.setBackground(Color.BLACK);
		ctLogin.setLayout(null); // 위치 직접 지정할꺼에여..
		
		LoginScreen loginWin = new LoginScreen("ASMR");
		loginWin.setVisible(true);
		ctLogin.add(loginWin);
	}
	public static void main(String[] args)
	{
		ASMRMain frame = new ASMRMain("ASMR");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 720, 480);
	}
}
