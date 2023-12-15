package network3.chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatClient implements ActionListener {
	JFrame f;

	JTextField connTF, sendTF;
	JButton connB, sendB;
	JTextArea ta;
	
	Socket s;
	ObjectInputStream in;
	ObjectOutputStream out;

	// 추가2 : 대화명을 바꾸기
	JTextField changeNameTF;
	JButton    changeNameB;

	
	// 추가 : 방인원의 대명 보여주기
	JList  memberList;
	Vector list;
	
	


	public ChatClient() {
		f = new JFrame("Chat Client");
		

		connTF = new JTextField("127.0.0.1");
		sendTF = new JTextField();
		connB = new JButton("접 속");
		sendB = new JButton("확 인");
		ta = new JTextArea(15,40);
		
		// 추가0: 대화명 바꾸기
		changeNameTF	= new JTextField("guest", 10);
		changeNameB		= new JButton("바꾸기");
		JPanel p_changeName = new JPanel();
		p_changeName.add( new JLabel("대화명 : "),"West" );
		p_changeName.add(changeNameTF, "Center");
		p_changeName.add(changeNameB, "East");
		
		JPanel p_serverName = new JPanel();
		p_serverName.setLayout( new BorderLayout() );
		p_serverName.add( new JLabel("서버입력 : "),"West" );
		p_serverName.add(connTF, "Center");
		p_serverName.add(connB, "East");

		JPanel p_north = new JPanel();
		p_north.setLayout( new GridLayout(1, 2));
		p_north.add( p_changeName );
		p_north.add( p_serverName );

		JPanel p2 = new JPanel();
		p2.setLayout( new BorderLayout() );
		p2.add( new JLabel("메세지입력 : "),"West" );
		p2.add(sendTF,"Center");
		p2.add(sendB, "East");
		
		// 추가2 : 방인원의 대명 보여주기
		memberList = new JList();
		list		= new Vector();
		JPanel  p_east = new JPanel();
		p_east.setLayout( new BorderLayout());
		p_east.add("North", new JLabel("   우 리 방 멤 버   "));
		p_east.add("Center", memberList );
		


		f.getContentPane().add("North", p_north);
		f.getContentPane().add("Center", new JScrollPane(ta));
		f.getContentPane().add("South", p2);
		f.getContentPane().add("East", p_east);
		
		//f.setSize(500, 300);
		f.pack();
		f.setVisible(true);
		
		connTF.addActionListener(this);
		connB.addActionListener(this);
		sendTF.addActionListener(this);
		sendB.addActionListener(this);

		//  추가0: 대화명 바꾸기
		changeNameTF.addActionListener(this);
		changeNameB.addActionListener(this);
	}// 생성자 종료
	
	public void actionPerformed( ActionEvent e ) {
		Object o = e.getSource();

		if( o == connTF || o == connB ) {
			connProc();
		}
		
		else if( o == sendTF || o == sendB ) {
			sendProc();
		}

		//  추가0: 대화명 바꾸기
		else if( o == changeNameTF || o == changeNameB ) {
			changeNameProc();
		}
	} // actionPerformed ends
	
	// [4] 입력한 대화명을 서버로 변경
	void changeNameProc(){
		try{

			
		} catch( Exception ex ) {
			ta.append(ex + "\n" );
		}
		
	}

	// [1] 서버에 접속
	void connProc() {						
		try{

		
			// [2] 쓰레드 구동
			//	2-1. Thread/Runnable 
			//	2-2. run() overriding
			//	2-3. start() 호출
		} catch(Exception ex) {
			ta.append( ex.toString() );
		}
	} // connProc ends
	

	// [3] 입력한 메세지를 서버로 전송
	void sendProc() {
		try{

		
		} catch( Exception ex ) {
			ta.append(ex + "\n" );
		}
	}// sendProc ends
	
	
	public static void main(String [] args ) {
		new ChatClient();
	}
	
}// ChatClient ends
			
			

	
		
