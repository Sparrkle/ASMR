package window;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import lib.TextLimit;

public class RegisterScreen extends JPanel implements ActionListener, ItemListener {

	 String Gender;
	 JTextField tfid; 
	 JTextField tfname;
	 JTextField tfaddress;
	 JPasswordField passwd;
	 JButton idck;
	 JButton regbtn;
	 JButton cancelbtn;
	 ImageIcon imgId = new ImageIcon("src/img/titleId.png");
	ImageIcon imgPw = new ImageIcon("src/img/titlePW.png");
	ImageIcon imgTf = new ImageIcon("src/img/textField.png");
	ImageIcon imgName = new ImageIcon("src/img/titleName.png");
	ImageIcon imgEmail = new ImageIcon("src/img/titleEmail.png");
	
	JLayeredPane jlpreg;
	ButtonGroup radioGroup;
	 JRadioButton[] radio;
	public RegisterScreen(JLayeredPane jlp3) {
		
		jlpreg=jlp3;
		this.setBounds(160, 50, 400, 350);
		this.setVisible(true);
		this.setLayout(null);
		this.setBorder(new LineBorder(Color.WHITE,2));
		this.setBackground(Color.BLACK);
		
		JPanel pnRegi = new JPanel();
		pnRegi.setBounds(0,  50,  450,  300);
		pnRegi.setOpaque(false); //배경을 투명색으로.
		this.add(pnRegi);
		pnRegi.setLayout(new BorderLayout(0, 20)); 
      
		JPanel  top = new JPanel();//정보입려패널
		JPanel  bottom = new JPanel();//버튼 패널
	    top.setOpaque(false);
		bottom.setOpaque(false);
		pnRegi.add(top, BorderLayout.CENTER); 
		pnRegi.add(bottom, BorderLayout.SOUTH); 
		top.setLayout(new GridLayout(5, 1));
		bottom.setLayout(new FlowLayout(FlowLayout.LEFT, 120,0));
		
		
		
		//id입력패녈 생성
	    JPanel pnid = new JPanel();
	    pnid.setOpaque(false);
	    pnid.setLayout(new FlowLayout(FlowLayout.LEFT, 10,10));  
	    JLabel lblid = new JLabel(imgId);
		tfid = new JTextField (8);
		tfid.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		tfid.setForeground(Color.WHITE); // 글자색 지정
		tfid.setOpaque(false);
		tfid.setBounds(2, 0, 180,40);
		tfid.setBorder(null);	 //테두리는 안보이게
		tfid.addKeyListener(new TextLimit(tfid, 16,"[a-zA-Z0-9_-]"));
		idck = new JButton("idcheck");
		idck.addActionListener(this);
		JLabel lblImageTfId = new JLabel(imgTf);
		lblImageTfId.add(tfid);
	    pnid.add(lblid);  pnid.add(lblImageTfId); pnid.add(idck);
	     
	     //패스워드 입력 패널
		 JPanel pnpw = new JPanel();
		 pnpw.setOpaque(false);
		 pnpw.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		 JLabel lblpw = new JLabel(imgPw);
		 passwd = new JPasswordField (8);
		 passwd.setForeground(Color.WHITE);
		 passwd.setOpaque(false);
		 passwd.setBounds(2, 0, 180,40);
		 passwd.setBorder(null);
		 passwd.addKeyListener(new TextLimit(passwd, 20, "[a-zA-Z0-9!@#$%^&*()+=-_`~]"));
		 JLabel lblImageTfPw = new JLabel(imgTf);
		 pnpw.add(lblImageTfPw);
		 lblImageTfPw.add(passwd);
		 pnpw.add(lblpw); pnpw.add(lblImageTfPw);
		 
		 //이름 입렵패널
		 JPanel pnname = new JPanel();
		 pnname.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		 pnname.setOpaque(false);
		 JLabel lblname = new JLabel(imgName);
		 tfname = new JTextField (20);
		 tfname.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		 tfname.setForeground(Color.WHITE); // 글자색 지정
		 tfname.addKeyListener(new TextLimit(tfname, 12));
		 tfname.setOpaque(false);
		 tfname.setBounds(2, 0, 180,40);
		 tfname.setBorder(null);	 //테두리는 안보이게
		 JLabel lblImageTfname = new JLabel(imgTf);
		 pnname.add(lblImageTfname);
		 lblImageTfname.add(tfname);
		 pnname.add(lblname); pnname.add(lblImageTfname); 
		
		 
		 //주소입력패널
         JPanel pnadr = new JPanel();
         pnadr.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
         pnadr.setOpaque(false);
		 JLabel lbladr = new JLabel(imgEmail);
		 tfaddress = new JTextField (20);
		 tfaddress.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		 tfaddress.setForeground(Color.WHITE); // 글자색 지정
		 tfaddress.setOpaque(false);
		 tfaddress.setBounds(2, 0, 180,40);
		 tfaddress.addKeyListener(new TextLimit(tfaddress, 128));
		 tfaddress.setBorder(null);	 //테두리는 안보이게
		 JLabel lblImageTfad = new JLabel(imgTf);
		 pnadr.add(lblImageTfad);
		 lblImageTfad.add(tfaddress);
		 pnadr.add(lbladr); pnadr.add(lblImageTfad); 
		 
		 //성별체크 패널
		 JPanel pngender = new JPanel();
		 pngender.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		 pngender.setOpaque(false);
		 radioGroup = new ButtonGroup();
		 radio =new JRadioButton[2];
		 
		 radio[0]= new JRadioButton("men");
		 radioGroup.add(radio[0]);
		 radio[0].setOpaque(false);
		 radio[0].addItemListener(this);
		 radio[0].setForeground(Color.white);
		 
		 radio[1]=new JRadioButton("women");
		 radioGroup.add(radio[1]);
		 radio[1].setOpaque(false);
		 radio[1].addItemListener(this);
		 radio[1].setForeground(Color.white);
		 radio[0].setSelected(true); // 초기 선택값 지정
		
		 
		 JLabel lblgender = new JLabel("gender");
		 lblgender.setForeground(Color.white);
		 radio[0].addItemListener(this);
		 radio[1].addItemListener(this);
		 pngender.add(lblgender);  pngender.add(radio[0]); pngender.add(radio[1]);
		 
		 //top패널에 패널들 추가
		  top.add(pnid);  
		  top.add(pnpw); 
		  top.add(pnname);
		  top.add(pnadr);   
		  top.add(pngender);
		  
		 //바텀패널
		 JPanel btnpn = new JPanel();
		 btnpn.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		 btnpn.setOpaque(false);
		
		 bottom.add(btnpn);
		 regbtn = new JButton("register");
		 cancelbtn = new JButton("cancel");
		 btnpn.add(regbtn);
		 btnpn.add(cancelbtn);
		 regbtn.addActionListener(this);
		 cancelbtn.addActionListener(this);
		 
	}


	public void actionPerformed(ActionEvent ae) {
		
				

		if(ae.getActionCommand() == "register"){ //정보등록
		  String db_id, db_passwd, db_name, db_address, gender;
		 
		
	
			  try {
		          Class.forName("com.mysql.jdbc.Driver");  // mysql의 jdbc Driver 연결
		          System.err.println("JDBC-ODBC 드라이버를 정상적으로 로드함");
		        } catch(ClassNotFoundException e) {
		          System.err.println("드라이버 로드에 실패했습니다."); }
		         

		    try {                
		       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asm", "root", "Dncks$55");
		          System.out.println("DB 연결 완료."); 
		          Statement dbSt = con.createStatement();
		          System.out.println("JDBC 드라이버가 정상적으로 연결되었습니다.");
		          
		   
		   db_id = tfid.getText();    db_passwd = passwd.getText();  
		   db_name = tfname.getText();     
		   db_address = tfaddress.getText();
		   gender = Gender; // 아이템리스너에서 받아온 값을 저장한후 DB입력시 사용
		   String  strSql = "INSERT INTO userInfo (id, passwd, name,address,gender) VALUES ("+" '"+db_id+"','"+db_passwd+"','"+db_name+ "','"+db_address+"','"+gender+"');" ;
		   dbSt.executeUpdate(strSql);      // sql 질의어 실행
		   jlpreg.removeAll();//반투명패널을 제거하기위해 제거
		      AlertScreen alert = new AlertScreen("registered", jlpreg);//1차적으로 alert패널을 띄운후
		      jlpreg.add(alert, new Integer(3));      
		      LoginScreen loginWin = new LoginScreen("ASMR", jlpreg);//로그인패널을 띄우게되면 alert패널 확인버튼 입력시 자동으로 초기화면이보이게됨
		      jlpreg.add(loginWin,new Integer(1));
		      this.setVisible(false);
		     
		   System.out.println("데이터 삽입 완료");

		    dbSt.close();       
		    con.close();        // DB연동 끊기
		    } catch (SQLException e) {
		          System.out.println("SQLException : "+e.getMessage()); }
			
			
			
			 
		     	
			
		}
		else if(ae.getActionCommand() == "cancel"){
			 jlpreg.removeAll();//반투명 패널 없애기 위함
			 LoginScreen loginWin = new LoginScreen("ASMR", jlpreg);
		     jlpreg.add(loginWin,new Integer(1));
		     this.setVisible(false);
	}     
		else if(ae.getActionCommand() == "idcheck"){
			
			 try {
		          Class.forName("com.mysql.jdbc.Driver");  // mysql의 jdbc Driver 연결
		          System.err.println("JDBC-ODBC 드라이버를 정상적으로 로드함");
		        } catch(ClassNotFoundException e) {
		          System.err.println("드라이버 로드에 실패했습니다."); }
		         

		    try {                
		       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asm", "root", "Dncks$55");
		          System.out.println("DB 연결 완료."); 
		          Statement dbSt = con.createStatement();
		          System.out.println("JDBC 드라이버가 정상적으로 연결되었습니다.");
		          
		   
		   String  strSql = "select * from userInfo where id = '"+tfid.getText()+"';";
		   //dbSt.executeUpdate(strSql);
		   ResultSet result=dbSt.executeQuery(strSql);
		   boolean check = false;
		   
		   while(result.next()){
			   check = true;
		   }
		   if(check == false)
		   {
			   AlertScreen alert = new AlertScreen("Can Use Id", jlpreg);
				jlpreg.add(alert, new Integer(4)); 	
		    }
		   else
		   {
			   AlertScreen alert = new AlertScreen("Can Not Use Id", jlpreg);
				jlpreg.add(alert, new Integer(4)); 	
		   }

		    dbSt.close();       
		    con.close();        // DB연동 끊기
		    } catch (SQLException e) {
		          System.out.println("SQLException : "+e.getMessage()); }			
	}
}



	public void itemStateChanged(ItemEvent ae) {
		
		if(ae.getStateChange()==ItemEvent.DESELECTED){
			return;		
			}
			if(radio[0].isSelected()){
				Gender = "men"; 
			}
			if(radio[1].isSelected()){
				Gender = "women";
			}
		}
	}
	

