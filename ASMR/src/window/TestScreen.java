package window;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import lib.code.CodePanel;
import lib.code.CodeSourcePanel;
import lib.variable.VariableManager;

public class TestScreen extends JFrame
{
	public TestScreen()
	{
		this.setResizable(false);
		this.setTitle("ASMR");
		this.setSize(720, 480);
		Container ctLogin = getContentPane();
		ctLogin.setBackground(Color.BLACK);
		ctLogin.setLayout(null); // 위치 직접 지정할꺼에여..
		
		//JPanel panel = new JPanel();
		//panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		//panel.setBounds(275, 5, 150, 300);
		
		CodePanel pnCode = new CodePanel(470, 30, 220 ,380);
		ctLogin.add(pnCode);
		ctLogin.add(pnCode.createCodeSourcePanel(70, 10, 20, 3, new VariableManager(3), false));
		
		/*
		CodeSourcePanel pnCs = new CodeSourcePanel(400, 30, 70, 10, 20, 3);
		ctLogin.add(pnCs);
		ctLogin.add(pnCs.createCodePanel(220, 380));
		
		CodePanel panel = new CodePanel(470, 30, 220, 380);
		ctLogin.add(panel);
		*/
	}
	public static void main(String[] args) {
		TestScreen frame = new TestScreen();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 720, 480);
	}
}
