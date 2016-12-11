package window;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class StageScreen extends JPanel implements ActionListener
{
	String CurrenID;
	JTextField tfId;
	JPasswordField pfPw;
	JLabel lblId;
	JLabel lblPw;
	JLabel lblTitle;
	JButton btnReg;
	JButton btnJoin;
	JLayeredPane jlpstg;
	JPanel pnButton;
	JButton[] btnBack;
	ImageIcon imgId = new ImageIcon("src/img/titleId.png");
	ImageIcon imgPw = new ImageIcon("src/img/titlePW.png");
	ImageIcon imgTf = new ImageIcon("src/img/textField.png");
	ImageIcon imgLocked = new ImageIcon("src/img/Locked.png");
	ImageIcon imgUnlocked = new ImageIcon("src/img/Unlock.png");
	int StageNum;
	// ImageIcon region end
	
	public StageScreen(int stgNum, JLayeredPane jlp,String id)//매개변수를 통해받은 스테이지 넘버에 따라 버튼배열이 달라짐
	{	
		CurrenID=id;//수정 패널에 넘겨줄 id값
		jlpstg = jlp;
		this.setBounds(0, 0, 720, 480);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
        StageNum=stgNum;
		pnButton = new JPanel();
		pnButton.setBounds(50,  30,  610,  190);
		pnButton.setOpaque(false); //배경을 투명색으로.
		this.add(pnButton);
		pnButton.setLayout(new GridLayout(2, 6, 20, 20));
		
		btnBack = new JButton[12];
		for(int i=0; i<12; i++)
		{
			btnBack[i] = new JButton();
			btnBack[i] = new JButton();
			btnBack[i].setActionCommand(Integer.toString(i+1));
			btnBack[i].setContentAreaFilled(false);
			btnBack[i].setRequestFocusEnabled(false);
			btnBack[i].addActionListener(this);
			pnButton.add(btnBack[i]);
		}
		setStageButton();
		
		
		JPanel pnLogout = new JPanel();//로그아웃 입력시 초기화면으로
		pnLogout.setOpaque(false); //배경을 투명색으로.
		this.add(pnLogout);
		pnLogout.setBounds(0,  380,  200,  200);
		JButton LogoutBtn = new JButton("LogOut");
	
		pnLogout.add(LogoutBtn);
		LogoutBtn.setBounds(0,  0,  150,  150);
		
		JPanel pnModify = new JPanel();
		pnModify.setBounds(260,  380,  180,  200);
		pnModify.setOpaque(false); //배경을 투명색으로.
		this.add(pnModify);
		JButton ModifyBtn = new JButton("Modify");//수정을 위한 버튼
		pnModify.add(ModifyBtn);
		LogoutBtn.addActionListener(this);
	    ModifyBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand() == "LogOut"){
		      jlpstg.removeAll();
		      LoginScreen loginWin = new LoginScreen("ASMR", jlpstg);//기존 정보를 지우고 새롭게 신구 초기화면을 만들어서 패널에 출력
		      jlpstg.add(loginWin,new Integer(1));	
			
		}
		else if(ae.getActionCommand() == "Modify"){//수정 버튼 출력시
			JPanel blind = new JPanel();
			blind.setBounds(0,0,720,480);
			blind.setBackground(new Color(255,255,255,40));
			blind.setOpaque(true);
			
			ModifyScreen modify = new ModifyScreen(jlpstg, StageNum,CurrenID);// 스테이지 넘버를 주는 이유는 수정 패널에서 스테이지패널로 넘어올 매개변수가 필요함
			jlpstg.add(blind, new Integer(4));
			jlpstg.add(modify,new Integer(4));
			jlpstg.moveToFront(modify);
		
		    

	}
		else
		{
			GameScreen stageWin = new GameScreen(Integer.parseInt(ae.getActionCommand()), this);
			stageWin.setBounds(0, 0, 720, 480);
			stageWin.setVisible(true);
			jlpstg.add(stageWin, new Integer(10));
		}
	}
	
	public void setStageButton()
	{
		for(int i=0; i<12; i++)
		{
			if(i<=StageNum)
			{
				btnBack[i].setEnabled(true);
				btnBack[i].setText(Integer.toString(i+1));
				btnBack[i].setIcon(null);
				btnBack[i].setDisabledIcon(null);
				btnBack[i].setForeground(Color.white);
				btnBack[i].setFont(new Font("맑은 고딕", Font.PLAIN, 20));
			}
			else
			{
				btnBack[i].setText("");
				btnBack[i].setIcon(imgLocked);
				btnBack[i].setDisabledIcon(imgLocked);
				btnBack[i].setEnabled(false);
			}
		}
	}
	
	public void updateStageNum(int stageNumInput)
	{
		if(StageNum < stageNumInput)
		{
			StageNum++;
			String db_id, db_sN;
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
				 
		   db_id = CurrenID;//비교용  
		   db_sN = Integer.toString(StageNum);
		   String strSql =  "UPDATE userInfo SET stagenum = '" + db_sN+"' WHERE id = '"+db_id+"';";
		   dbSt.executeUpdate(strSql);      // sql 질의어 실행                 //  한줄로 작성
	       System.out.println("데이터 수정 완료");	
		   }
		   catch (SQLException e) {
		          System.out.println("SQLException : "+e.getMessage());
		   } 
		}
	}
}
