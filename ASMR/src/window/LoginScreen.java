package window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lib.GlitchImage;
import lib.TextLimit;

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

	// ImageIcon region start
	
	/*
	 * GlitchLib을 쓰기 위한 Glitch Animation Images
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	
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
	
	ImageIcon imgId = new ImageIcon("src/img/titleId.png");
	ImageIcon imgPw = new ImageIcon("src/img/titlePW.png");
	ImageIcon imgTf = new ImageIcon("src/img/textField.png");
	
	// ImageIcon region end
	
	public LoginScreen(String title)
	{
		/*
		 * 윈도우 기본 설정
		 */
		setResizable(false);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 480);
		ctLogin = getContentPane();
		ctLogin.setBackground(Color.BLACK);
		ctLogin.setLayout(null); // 위치 직접 지정할꺼에여..
		
		
		/*
		 * 기본 UI 생성
		 */
		JPanel pnLogin = new JPanel();
		pnLogin.setBounds(180,  270,  305,  100);
		pnLogin.setOpaque(false); //배경을 투명색으로.
		ctLogin.add(pnLogin);
		pnLogin.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pnLoginId = new JPanel();
		pnLoginId.setBackground(Color.WHITE);
		pnLoginId.setOpaque(false);
		pnLogin.add(pnLoginId);
		pnLoginId.setLayout(null);
		
		JPanel pnLoginPw = new JPanel();
		pnLoginPw.setBackground(Color.WHITE);
		pnLoginPw.setOpaque(false);
		pnLogin.add(pnLoginPw);
		pnLoginPw.setLayout(null);
		
		lblId = new JLabel(imgId);
		lblId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblId.setBounds(10, 15, 100, 20);
		pnLoginId.add(lblId);
		
		lblPw = new JLabel(imgPw);
		lblPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblPw.setBounds(10, 15, 100, 20);
		pnLoginPw.add(lblPw);
		
		tfId = new JTextField(20);
		tfId.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		tfId.setForeground(Color.WHITE); // 글자색 지정
		tfId.setOpaque(false);
		tfId.setBounds(2, 0, 185, 30);
		tfId.setBorder(null);	 //테두리는 안보이게
		tfId.addKeyListener(new TextLimit(tfId, 16,"[a-zA-Z0-9_-]"));
		pnLoginId.add(tfId);
		
		pfPw = new JPasswordField(20);
		pfPw.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		pfPw.setForeground(Color.WHITE);
		pfPw.setOpaque(false);
		pfPw.setBounds(2, 0, 185, 30);
		pfPw.setBorder(null);
		pfPw.addKeyListener(new TextLimit(pfPw, 20, "[a-zA-Z0-9!@#$%^&*()+=-_`~]"));
		pnLoginPw.add(pfPw);
		
		btnReg = new JButton("Register");
		btnReg.setBounds(310, 405, 100, 25);
		ctLogin.add(btnReg);
		btnReg.addActionListener(this);
		
		btnJoin = new JButton("Join");
		btnJoin.setBounds(310, 375, 100, 25);
		ctLogin.add(btnJoin);
		
		lblTitle = new JLabel();
		lblTitle.setBounds(50, 50, 620, 120);
		ctLogin.add(lblTitle);
		
		
		/*
		 * Image 설정
		 */
		lblTitle.setIcon(titleImage[0]);
		GlitchImage glitchEffect = new GlitchImage(titleImage, lblTitle, 2500, 60, 6);
		glitchEffect.start();
		
		/*
		 * TextField의 배경 이미지를 따로 설정할 수가 없어서... label에 imageIcon을 넣은 후
		 * TextField를 label에 add했다. 물론 label은 위에서 투명화 시켜놓았음!
		 */
		JLabel lblImageTfId = new JLabel(imgTf);
		lblImageTfId.setBounds(117, 10, 183, 30);
		pnLoginId.add(lblImageTfId);
		lblImageTfId.add(tfId);
		
		JLabel lblImageTfPw = new JLabel(imgTf);
		lblImageTfPw.setBounds(117, 10, 183, 30);
		pnLoginPw.add(lblImageTfPw);
		lblImageTfPw.add(pfPw);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand() == "Register")
		{
		}
		else if(ae.getActionCommand() == "Join")
		{
		}
	}
}
