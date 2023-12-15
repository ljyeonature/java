package thread.basic;

class Bread 
{
	String bread;

	//##  	
	boolean isCheck = false;

	public void setBread( String bread )
	{
		this.bread = bread;
		//## 		
	
		isCheck = true;
		synchronized (this) {
			notifyAll();
		}

	}	

	public String getBread()
	{
		//## 빵이 다 만들어지지 않으면,  
		if (isCheck == false) {
			try {
				// 다른 스레드 작업 노
				synchronized (this) {
					wait();
				}
			} catch (Exception e) {}
		}

		return bread;
	}
}

class Baker extends Thread
{
	Bread bbang;

	Baker( Bread bbang )
	{
		this.bbang = bbang;
	}
	public void run()
	{
		bbang.setBread("진열된 완성된 맛있는 빵");
	}
}

class Customer extends Thread
{
	Bread bbang;

	Customer( Bread bbang )
	{
		this.bbang = bbang;
	}
	public void run()
	{
		System.out.println("빵을 사감 : " + bbang.getBread());
	}
}

class Ex8_BreadTest
{
	public static void main(String[] args) 
	{
		Bread  bread = new Bread();

		Baker  baker = new Baker( bread );
		Customer customer = new Customer( bread );
		baker.start();
		customer.start();

		try{
			customer.join();
			baker.join();			
		}catch( Exception ex ){}

	}
}
