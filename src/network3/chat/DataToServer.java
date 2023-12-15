package network3.chat;

import java.io.Serializable;

public class DataToServer implements Serializable {
	
	// 클라이언트에서 서버로 전송할 상태값 선언
	public static final int SEND_MESSAGE = 100;
	public static final int CHANGE_NAME = 200;

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
