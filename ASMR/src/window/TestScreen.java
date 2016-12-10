package window;

import java.awt.*;
import javax.swing.*;

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
		
		try
		{
			GameScreen stageWin = new GameScreen(1);
			stageWin.setBounds(0, 0, 720, 480);
			stageWin.setVisible(true);
			ctLogin.add(stageWin);
		}
		catch (Exception e)
		{
			
		}
	}
	
	public static void main(String[] args)
	{
		TestScreen frame = new TestScreen();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 720, 480);
	}
}
