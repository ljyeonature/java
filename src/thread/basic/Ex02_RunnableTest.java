package thread.basic;

public class Ex02_RunnableTest {
    public static void main(String[] args) {

        MakeCar2 mc1 = new MakeCar2("차틀만들기");
        
        Thread t1 = new Thread(mc1);
        t1.start(); // -> run() 호출

        new Thread(new MakeCar2("도색작업")).start();

        System.out.println("작업 끝");

        
    }
}
class MakeCar2 implements Runnable{
    String work;
    MakeCar2(String work){
        this.work  = work;
    }

    public void run() {
        for(int i=0;  i<5; i++){
            System.out.println(work+"작업중");
            try {
                Thread.sleep(500);
            } catch (Exception ex) {}
        }
    }
}