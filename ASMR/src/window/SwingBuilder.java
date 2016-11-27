package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SwingBuilder extends JFrame {

	JTextField tfId;
	JPasswordField pfPw;
	JLabel lblId;
	JLabel lblPw;
	JLabel lblTitle;
	JButton btnReg;
	JButton btnJoin;
	Container ctLogin;
	
	public SwingBuilder()
	{
		/*
		 * À©µµ¿ì ±âº» ¼³Á¤
		 */
		setResizable(false);
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
	}

}
