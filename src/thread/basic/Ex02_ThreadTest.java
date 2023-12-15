package thread.basic;

public class Ex02_ThreadTest {
    // 메인에서 제어권 1번(main)
    public static void main(String[] args) {
        MakeCar1 mc1 = new MakeCar1("차틀만들기");
        // 2번 제어권
        mc1.start(); // -> run()호출

        // 3번 제어권
        new MakeCar1("엔진부착").start();

        System.out.println("종료");
    }
}

class MakeCar1 extends Thread{
    String work;
    MakeCar1(String work){
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
