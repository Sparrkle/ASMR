package window;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

import lib.*;

public class LoginScreen extends JPanel implements ActionListener
{
	JTextField tfId;
	JPasswordField pfPw;
	JLabel lblId;
	JLabel lblPw;
	JLabel lblTitle;
	JButton btnReg;
	JButton btnJoin;
	JLayeredPane jlp2;
	JPanel alert;
	int Stage;
	String Currentid;
	// ImageIcon region start
	
	/*
	 * GlitchLib을 쓰기 위한 Glitch Animation Images
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
	
	ImageIcon imgId = new ImageIcon("src/img/titleId.png");
	ImageIcon imgPw = new ImageIcon("src/img/titlePW.png");
	ImageIcon imgTf = new ImageIcon("src/img/textField.png");
	ImageIcon imgBtnReg = new ImageIcon("src/img/btnMainRegister.png");
	ImageIcon imgBtnLog = new ImageIcon("src/img/btnMainLogin.png");
	
	// ImageIcon region end
	
	public LoginScreen(String title, JLayeredPane jlp3)
	{	
		jlp2=jlp3; // JLayeredPane을 저장
		this.setBounds(0, 0, 720, 480);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		JPanel pnLogin = new JPanel(); // 통합 패널
		pnLogin.setBounds(180,  270,  305,  100);
		pnLogin.setOpaque(false); //배경을 투명색으로.
		this.add(pnLogin);
		pnLogin.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pnLoginId = new JPanel(); //id패널
		pnLoginId.setBackground(Color.WHITE);
		pnLoginId.setOpaque(false);
		pnLogin.add(pnLoginId);
		pnLoginId.setLayout(null);
		
		JPanel pnLoginPw = new JPanel(); //pw패널
		pnLoginPw.setBackground(Color.WHITE);
		pnLoginPw.setOpaque(false);
		pnLogin.add(pnLoginPw);
		pnLoginPw.setLayout(null);
		
		lblId = new JLabel(imgId); 
		lblId.setBounds(10, 15, 100, 20);
		pnLoginId.add(lblId);
		
		lblPw = new JLabel(imgPw);
		lblPw.setBounds(10, 15, 100, 20);
		pnLoginPw.add(lblPw);
		
		tfId = new JTextField(20);  //id입력 텍스트필드
		tfId.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		tfId.setForeground(Color.WHITE); // 글자색 지정
		tfId.setOpaque(false);
		tfId.setBounds(2, 0, 185, 30);
		tfId.setBorder(null);	 //테두리는 안보이게
		tfId.addKeyListener(new TextLimit(tfId, 16,"[a-zA-Z0-9_-]"));//lib에 만들어둔 textLimit클래스를 이용하여 입력 받을 글자수및 타입 지정	
		pfPw = new JPasswordField(20);
		pfPw.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		pfPw.setForeground(Color.WHITE);
		pfPw.setOpaque(false);
		pfPw.setBounds(2, 0, 185, 30);
		pfPw.setBorder(null);
		pfPw.addKeyListener(new TextLimit(pfPw, 20, "[a-zA-Z0-9!@#$%^&*()+=-_`~]"));//lib에 만들어둔 textLimit클래스를 이용하여 입력 받을 글자수및 타입 지정
		
		btnReg = new JButton();
		btnReg.setActionCommand("Register");
		btnReg.setIcon(imgBtnReg);
		btnReg.setBounds(310, 405, 100, 25);
		this.add(btnReg);
		btnReg.addActionListener(this);
		
		btnJoin = new JButton();
		btnJoin.setActionCommand("login");
		btnJoin.setIcon(imgBtnLog);
		btnJoin.setBounds(310, 375, 100, 25);
		this.add(btnJoin);
		btnJoin.addActionListener(this);
		lblTitle = new JLabel();
		lblTitle.setBounds(50, 50, 620, 120);
		this.add(lblTitle);
		
		
		
		lblTitle.setIcon(titleImage[0]);
		GlitchImage glitchEffect = new GlitchImage(titleImage, lblTitle, 2500, 60, 6);
		glitchEffect.start();
		
		
		JLabel lblImageTfId = new JLabel(imgTf); // img를 텍스트필드에 줄수없어서 label에 텍스트필드를 넣고 label에 이미지를 추가시킴
		lblImageTfId.setBounds(117, 10, 183, 30);
		pnLoginId.add(lblImageTfId);
		lblImageTfId.add(tfId);
		
		JLabel lblImageTfPw = new JLabel(imgTf); // img를 텍스트필드에 줄수없어서 label에 텍스트필드를 넣고 label에 이미지를 추가시킴
		lblImageTfPw.setBounds(117, 10, 183, 30);
		pnLoginPw.add(lblImageTfPw);
		lblImageTfPw.add(pfPw);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getActionCommand() == "login")
		{
	
			
			 try {
		         Class.forName("com.mysql.jdbc.Driver");   
		         System.err.println("JDBC-ODBC 드라이버를 정상적으로 로드함");
		     } catch(ClassNotFoundException e) {
		         System.err.println("드라이버 로드에 실패했습니다."); }

		     try {         
		         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asm", "root", "Dncks$55");
		          System.out.println("DB 연결 완료."); 
		          Statement dbSt = con.createStatement();
		          System.out.println("JDBC 드라이버가 정상적으로 연결되었습니다.");
		          
		          String  strSql;
		         // 로그인 버튼을 누르면 id와 password를 DB에서 찾기
		    String t_id, t_passwd;
		    t_id=tfId.getText();   t_passwd=pfPw.getText();  
		                                  
		    strSql="SELECT * FROM userInfo WHERE id='"+t_id+"' and passwd = '"+t_passwd+"';";				
		    ResultSet result=dbSt.executeQuery(strSql);
		    if(result.next())
		    { 
			    String stageNum;
			    stageNum = result.getString("stagenum");
			    Currentid = result.getString("id"); //추후 회원 정보수정시 ID를 통하여 정보를 비교하여야하기문에 매개변수로 값을 넘겨야함, 따라서 저장해놓음
			    try
			    {
			    	Stage = Integer.parseInt(stageNum); // 스테이지 클리어 정보를 저장하고 스테이지 스크린에서 그에따라 클리어한 스테이지만큼만 Lock이 풀려야하니 해당 정보 매개변수로 사용
			    }
			    catch(NumberFormatException nfe)
			    {
			    	Stage = 0;
			    }
			    
		    	StageScreen stg = new StageScreen(Stage, jlp2,Currentid);//id정보도 같이넘겨줌
				jlp2.add(stg, new Integer(2));
		   } 
		    else
		    { 
			   AlertScreen alert = new AlertScreen("login incorrect", jlp2); //login이 안瑛뻥?미리만들어놓은 alert패널에 값을 출력, 메시지 다이얼로그와 같은기능을함
			    jlp2.add(alert, new Integer(3));
		    }
		      dbSt.close();
		      con.close();              
		    } catch (SQLException e) {
		         System.out.println("SQLException : "+e.getMessage()); }
			
			
		}
		else if(ae.getActionCommand() == "Register")
		{
			JPanel blind = new JPanel(); //레지스터 패널 출력시 크기가 작아 뒤에있는 패널을 사용항수있음, 따라서 반투명 패널을 임의로 설정하여 상단에 배치함으로써 뒤쪽 패널 이용을 불가능하게 만듦
			blind.setBounds(0,0,720,480);
			blind.setBackground(new Color(255,255,255,40));
			blind.setOpaque(true);
			
		
			RegisterScreen reg = new RegisterScreen(jlp2); // 반투명 패널을 띄운뒤 레지스터 패널 띄움
			jlp2.add(blind, new Integer(2)); 
		    jlp2.add(reg, new Integer(3));
			this.setEnabled(false);
		}
	
			
		}
			 
	}
	
	


