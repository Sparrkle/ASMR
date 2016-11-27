package window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import lib.GlitchLib;

public class LoginScreen extends JFrame implements ActionListener
{
	JTextField tfId;
	JPasswordField pfPw;
	JLabel lblId;
	JLabel lblPw;
	JLabel lblTitle;
	JButton btnReg;
	JButton btnJoin;
	Container ctLogin;

	/*
	 * GlitchLibÀ» ¾²±â À§ÇÑ Glitch Animation Images
	 */
	ImageIcon[] titleImage =
	{
		new ImageIcon("src/img/defaultNew.png"),
		new ImageIcon("src/img/defaultNewGB.png"),
		new ImageIcon("src/img/defaultNewRB.png"),
		new ImageIcon("src/img/defaultNewRBGB.png"),
		new ImageIcon("src/img/defaultGlitch.png"),
		new ImageIcon("src/img/defaultGlitch2.png"),
		new ImageIcon("src/img/defaultGlitch3.png"),
		new ImageIcon("src/img/glitch1.png"),
		new ImageIcon("src/img/glitch2.png"),
		new ImageIcon("src/img/glitch3.png"),
		new ImageIcon("src/img/glitch4.png"),
		new ImageIcon("src/img/glitch5.png"),
		new ImageIcon("src/img/glitch6.png"),
		new ImageIcon("src/img/glitch7.png"),
		new ImageIcon("src/img/glitch8.png"),
		new ImageIcon("src/img/glitch9.png"),
		new ImageIcon("src/img/glitch10.png"),
		new ImageIcon("src/img/glitch11.png")
	};
	
	public LoginScreen(String title)
	{
		/*
		 * À©µµ¿ì ±âº» ¼³Á¤
		 */
		setResizable(false);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 480);
		ctLogin = getContentPane();
		ctLogin.setBackground(Color.BLACK);
		ctLogin.setLayout(null); // À§Ä¡ Á÷Á¢ ÁöÁ¤ÇÒ²¨¿¡¿©..
		
		
		/*
		 * ±âº» UI »ý¼º
		 */
		JPanel pnLogin = new JPanel();
		pnLogin.setBounds(215,  275,  270,  90);
		ctLogin.add(pnLogin);
		pnLogin.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pnLoginId = new JPanel();
		pnLoginId.setBackground(Color.WHITE);
		pnLogin.add(pnLoginId);
		pnLoginId.setLayout(null);
		
		JPanel pnLoginPw = new JPanel();
		pnLoginPw.setBackground(Color.WHITE);
		pnLogin.add(pnLoginPw);
		pnLoginPw.setLayout(null);
		
		lblId = new JLabel("id :");
		lblId.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblId.setBounds(51, 15, 20, 15);
		pnLoginId.add(lblId);
		
		lblPw = new JLabel("password :");
		lblPw.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblPw.setBounds(11, 15, 65, 15);
		pnLoginPw.add(lblPw);
		
		tfId = new JTextField(20);
		tfId.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		tfId.setForeground(Color.BLACK);
		tfId.setBackground(Color.WHITE);
		tfId.setBounds(80, 7, 185, 30);
		pnLoginId.add(tfId);
		
		pfPw = new JPasswordField(20);
		pfPw.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		pfPw.setForeground(Color.BLACK);
		pfPw.setBackground(Color.WHITE);
		pfPw.setBounds(80, 7, 185, 30);
		pnLoginPw.add(pfPw);
		
		btnReg = new JButton("Register");
		btnReg.setBounds(310, 405, 100, 25);
		ctLogin.add(btnReg);
		
		btnJoin = new JButton("Join");
		btnJoin.setBounds(310, 375, 100, 25);
		ctLogin.add(btnJoin);
		
		lblTitle = new JLabel();
		lblTitle.setBounds(50, 50, 620, 120);
		ctLogin.add(lblTitle);
		
		
		/*
		 * Image ¼³Á¤
		 */
		lblTitle.setIcon(titleImage[0]);
		GlitchLib glitchEffect = new GlitchLib(titleImage, lblTitle, 2500, 60, 7);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
	}
}
