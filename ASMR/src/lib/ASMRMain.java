package lib;

import java.awt.*;

import javax.swing.*;

import window.*;

public class ASMRMain extends JFrame
{
	JLayeredPane jlp = new JLayeredPane();
	public ASMRMain(String title)
	{
		this.setResizable(false);//크기변경불가
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(720, 480);
		Container ctLogin = getContentPane();
		ctLogin.setBackground(Color.BLACK);
		ctLogin.setLayout(null);
		
		LoginScreen loginWin = new LoginScreen("ASMR", jlp);// 초기화면 클래스만 생성
		
		jlp.add(loginWin, new Integer(1)); //프레임을 하나만 유지할것이기 문에  JLAyeredPane이용 패널을 바꾸는 형식으로 진행됨, 숫자가 클수록 최상위 레이어, 
		jlp.setBounds(0,0,720,480);
		jlp.setLayout(null);
		ctLogin.add(jlp);
		
	}
	public static void main(String[] args)
	{
		ASMRMain frame = new ASMRMain("ASM");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setBounds(100, 100, 720, 480);
	}
}
