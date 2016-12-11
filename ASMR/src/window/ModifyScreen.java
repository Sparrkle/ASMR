package window;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import lib.TextLimit;

public class ModifyScreen extends JPanel implements ActionListener, ItemListener {

	 String currentID;
	 JTextField tfid; 
	 JTextField tfname;
	 JTextField tfaddress;
	 JPasswordField passwd;
	 JButton idck;
	 JButton modifybtn;
	 JButton cancelbtn;
	 JButton deletebtn;
	 JLayeredPane jlpmdf;
	 ImageIcon imgId = new ImageIcon("src/img/titleId.png");
	 ImageIcon imgPw = new ImageIcon("src/img/titlePW.png");
	 ImageIcon imgTf = new ImageIcon("src/img/textField.png");
	 ImageIcon imgName = new ImageIcon("src/img/titleName.png");
	 ImageIcon imgEmail = new ImageIcon("src/img/titleEmail.png");
	 String Gender;
	 int StgNum;
	 ButtonGroup radioGroup;
	 JRadioButton[] radio;

	public ModifyScreen(JLayeredPane jlp, int stg, String id) {
		currentID = id;
		jlpmdf = jlp;
		StgNum = stg;
		this.setBounds(190, 50, 320, 350);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.setBorder(new LineBorder(Color.WHITE,2));
		JPanel pnRegi = new JPanel();//통합패널
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
		bottom.setLayout(new FlowLayout(FlowLayout.LEFT, 20,0));
		
		
		
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
		 radio[0].setSelected(true);//초기설정 버튼
		 JLabel lblgender = new JLabel("gender");
		 lblgender.setForeground(Color.white);
		 pngender.add(lblgender);  pngender.add(radio[0]); pngender.add(radio[1]); 
		 
		 //top패널에 패널들 추가 
		  top.add(pnpw); 
		  top.add(pnname);
		  top.add(pnadr);   
		  top.add(pngender);
		 //바텀패널
		 JPanel btnpn = new JPanel();
		 btnpn.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		 btnpn.setOpaque(false);
		
		 bottom.add(btnpn);
		 modifybtn = new JButton("modify");
		 deletebtn= new JButton("delete");
		 cancelbtn = new JButton("cancel");
		 btnpn.add(modifybtn);
		 btnpn.add(deletebtn);
		 btnpn.add(cancelbtn);
	     modifybtn.addActionListener(this);
		 deletebtn.addActionListener(this);
		 cancelbtn.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent ae) {
		String db_id, db_passwd, db_name, db_address, gender;// 어떤버튼이라도 클릭시 디비 연동
		try {
	          Class.forName("com.mysql.jdbc.Driver");  // mysql의 jdbc Driver 연결하기
	          System.err.println("JDBC-ODBC 드라이버를 정상적으로 로드함");
	        } catch(ClassNotFoundException e) {
	          System.err.println("드라이버 로드에 실패했습니다."); }
	   try {         // 내가 mysql에 만든 student 데이터베이스에 연결하기
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asm", "root", "Dncks$55");
	   System.out.println("DB 연결 완료.");
	   Statement dbSt = con.createStatement();
	   System.out.println("JDBC 드라이버가 정상적으로 연결되었습니다.");
	   
		
		if(ae.getActionCommand() == "modify"){
			 
			   db_id = currentID;//비교용  
			   db_passwd = passwd.getText();  
			   db_name = tfname.getText();     
			   db_address = tfaddress.getText();
			   gender = Gender;
			   String strSql =  "UPDATE userInfo SET passwd = '"+db_passwd+"', name = '"+  db_name+"', address = '" +db_address+"', gender = '" + gender+"' WHERE id = '"+db_id+"';";
			   dbSt.executeUpdate(strSql);      // sql 질의어 실행                 //  한줄로 작성
		       System.out.println("데이터 수정 완료");	
			  jlpmdf.removeAll();//수정창으로 돌아가고 반투명 레이어를 없애기위해 삭제
		      AlertScreen alert = new AlertScreen("registered", jlpmdf);
		      jlpmdf.add(alert, new Integer(3));
		      StageScreen stg = new StageScreen(StgNum, jlpmdf,currentID);//매개변수로 받아왔던값 그대로 리턴하여 기존과 똑같은 스테이지 스크린 생성
		      jlpmdf.add(stg, new Integer(2));
		     		
		}
		else if(ae.getActionCommand() == "delete"){
			   db_id = currentID;  //id를 매개변수로 받아왔었음                                  
			   String strSql="DELETE FROM userInfo WHERE id = '"+db_id+"';";   
			   dbSt.executeUpdate(strSql);      // sql 질의어 실행 
			    System.out.println("데이터 삭제 완료");
			   jlpmdf.removeAll();
			    AlertScreen alert = new AlertScreen("deleted", jlpmdf);
			    jlpmdf.add(alert, new Integer(3));
			    //StageScreen stg = new StageScreen(StgNum, jlpmdf,currentID);	
			    //jlpmdf.add(stg, new Integer(2));
			    LoginScreen loginWin = new LoginScreen("ASM", jlpmdf);// 초기화면 클래스만 생성
			    jlpmdf.add(loginWin, new Integer(2));
			
		}
			
			     
		else{//그냥 취소버튼 누를시
		jlpmdf.removeAll();
		StageScreen stg = new StageScreen(StgNum, jlpmdf,currentID);	
	    jlpmdf.add(stg, new Integer(2));
		this.setVisible(false);
		}
		 dbSt.close();  //if문이 끝나고 DB를 닫음     
		 con.close();
	   }catch (SQLException e) {
	          System.out.println("SQLException : "+e.getMessage()); }
	   }  
	


	
	public void itemStateChanged(ItemEvent ae) {//라디오박스 입력값에 따른 성별저장을 위한 아이템 이벤트
	
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
