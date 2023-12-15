package network3.chat;

import java.io.Serializable;

public class DataToClient  implements Serializable{
	
	// 서버에서 클라이언트로 보내는 상태지정
	public static final int SEND_MESSAGE = 100;
	

	// 전송할 상태값과 데이타
	Object data;
	int state;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
