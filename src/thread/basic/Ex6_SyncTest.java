package thread.basic;

class Count{
    int i=0;
    /*
     *  synchronized void increment() {
        i++;
    }
     */
    void increment() {
        synchronized (this) {
            i++;
        }
        // 다른 작업들
    }
}

class ThreadCount extends Thread{
    Count cnt;

    ThreadCount(Count cnt) {
        this.cnt = cnt;
    }

    public void run() {
        for(int i=0; i<100000000; i++) {
            cnt.increment();
        }
    }
}


public class Ex6_SyncTest {
    public static void main(String[] args) {
        
        Count count = new Count();

        ThreadCount one = new ThreadCount(count);
        ThreadCount two = new ThreadCount(count);

        one.start();
        two.start();

        try {
            one.join();
            two.join();

        } catch (Exception e) {

        }

        System.out.println("i의 값: " + count.i);
        
    }
}
