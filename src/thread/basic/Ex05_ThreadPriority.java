package thread.basic;

public class Ex05_ThreadPriority {
    // 메인에서 제어권 1번(main)
    public static void main(String[] args) {
        MakeCar mc1 = new MakeCar("차틀만들기", Thread.NORM_PRIORITY); // 5(자동 5 숫자)
        // 2번 제어권
        mc1.start(); // -> run()호출

        // 3번 제어권
        MakeCar mc2 = new MakeCar("엔진부착", Thread.MAX_PRIORITY); // 10
        mc2.start();

        MakeCar mc3 = new MakeCar("도색작업", Thread.MIN_PRIORITY); // 1
        mc3.start();

    }
}

class MakeCar extends Thread{
    String work;
    MakeCar(String work, int priority){
        this.work  = work;

        setPriority(priority); // 우선순위 지정
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