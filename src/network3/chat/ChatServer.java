package network3.chat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ChatServer implements Runnable {
	ArrayList vc = new ArrayList();

	public void run() {
		ServerSocket ss = null;
		try{
			ss = new ServerSocket(1234);
		}catch( Exception e ) {
			System.out.println(e);
		}

		while(true) {
			try{
				Socket s = ss.accept();
				System.out.println("Client 가 접속시도 :" + s );
				ChatService cs = new ChatService(s);
				cs.start();
				vc.add(cs);

			} catch( Exception e ) { }
		}
	}  // run ends

	public static void main( String [] arg ) {
		ChatServer cs = new ChatServer();
		new Thread(cs).start();
	}



	class ChatService extends Thread {
		String myname = "quest";
		ObjectInputStream in;
		ObjectOutputStream out;
		ChatService( Socket s ) {
			try{
				out = new ObjectOutputStream(s.getOutputStream());
				in = new ObjectInputStream(s.getInputStream());
				
			}catch( Exception e ) {
				System.out.println("소켓스트림 실패");
				e.printStackTrace();
			}
		}// 생성자 종료



		public void run() {
			while(true) {
				try{
					DataToServer dts = (DataToServer)in.readObject();
					String msg = (String)dts.getData();
					int state = dts.getState();
					System.out.println("상태:" + state);

					switch(state)
					{	
					case DataToServer.SEND_MESSAGE : 
						putMessageAll( myname + ">" + msg );
						break;
					case DataToServer.CHANGE_NAME :
						putMessageAll( myname + "님이 대화명을 " + msg +"으로 변경하였습니다" );
						this.myname = msg;						
						break;
					}


				}catch( Exception ex ) { return; }

			}
		}// run ends


		void putMessageAll( String msg ) {
			for( int i =0 ; i<vc.size() ; i++ ) {
				ChatService cs = ( ChatService ) vc.get(i);

				try {
					cs.putMessage(msg);
				}catch( Exception e ) {
					vc.remove(i--);
				}
			}
		} // putMessageAll ends

		void putMessageTo( String towhom, String msg ) {
			for( int i=0; i<vc.size() ; i++ ) {
				ChatService cs = ( ChatService ) vc.get(i);
				if( towhom.equalsIgnoreCase( cs.myname )) {
					try{
						cs.putMessage( towhom +">"+ msg);
						break;
					}catch( Exception ex ) { }
				}
			}
		} // putMessageTo ends

		void putMessage( String msg )
				throws Exception {
			DataToClient dtc = new DataToClient();
			dtc.setData(msg);
			dtc.setState(DataToClient.SEND_MESSAGE);
			out.writeObject( dtc);
		}

	} // ChatService class ends


}// ChatServer class ends
