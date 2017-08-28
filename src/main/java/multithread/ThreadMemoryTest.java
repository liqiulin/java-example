package multithread;

/**
 * Created by liqiulin on 2017/4/10.
 */
public class ThreadMemoryTest {
    public static void main(String[] args) {

        for (int i = 0; i< 1000000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(10000000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println(i);
        }
    }
}
