package window;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;



public class AlertScreen extends JPanel implements ActionListener {

	

	 JButton OK;
	 String Message;
	 JLayeredPane alt;

	public AlertScreen(String Msg, JLayeredPane jlp) {
		alt = jlp;
		Message = Msg; // alert패널이 호출될때 상황에 따른 메시지를 입력받음으로서 각 각 상황에 맞게 메시지를 출력가능하게함
		this.setBounds(250,150, 200, 200);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.setBorder(new LineBorder(Color.WHITE,2));// 테두리에 흰색을 줌으로서 조금더 깔끔하게 연출
		JPanel pnalr = new JPanel();
		pnalr.setBounds(25, 50, 150,  100);
		pnalr.setOpaque(false); 
		this.add(pnalr);
 
      
		JPanel  top = new JPanel();// 메시지 출력용 상단 패널
		JPanel  bottom = new JPanel();// 버튼 출력용 하단 패널
	    top.setOpaque(false);
		bottom.setOpaque(false);
		pnalr.add(top, BorderLayout.CENTER); 
		pnalr.add(bottom, BorderLayout.SOUTH); 
	
		
		//상단패널
	    
		 JPanel pnmsg = new JPanel(); 
		 pnmsg.setLayout(new FlowLayout(FlowLayout.CENTER));
		 pnmsg.setOpaque(false);
		 JLabel lblmsg = new JLabel(Message); 
		 lblmsg.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		 lblmsg.setForeground(Color.WHITE); // 글자색 지정
		 pnmsg.add(lblmsg);
		  top.add(pnmsg);
		 
		  //바텀패널
		  
		 JPanel btnpn = new JPanel();	 
		 btnpn.setLayout(new FlowLayout(FlowLayout.CENTER));
		 btnpn.setOpaque(false);
		 OK = new JButton("OK");
		 btnpn.add(OK);
		 bottom.add(btnpn);
		 OK.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent ae) {
		
		this.setEnabled(false);
		alt.setLayer(this, new Integer(0));//패널 맨뒤로 보낸뒤 삭제, 바로 삭제시 잔상이 패널에 남아 먼저 패널뒤로 보낸후 삭제하도록 하였음
		alt.remove(this);
		
		
	
	}
}
