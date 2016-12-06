package window;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import lib.code.CodePanel;
import lib.variable.VariableManager;

public class TestScreen extends JFrame
{
	public TestScreen()
	{
		this.setResizable(false);
		this.setTitle("ASMR");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(720, 480);
		Container ctLogin = getContentPane();
		ctLogin.setBackground(Color.BLACK);
		ctLogin.setLayout(null); // 위치 직접 지정할꺼에여..
		
		//JPanel panel = new JPanel();
		//panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		//panel.setBounds(275, 5, 150, 300);
		CodePanel panel = new CodePanel(new VariableManager(5), 470, 30, 220, 380);
		
		ctLogin.add(panel);
	}
	public static void main(String[] args) {
		TestScreen frame = new TestScreen();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 720, 480);
	}
}
