package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liqiulin on 2017/8/25.
 */
public class ThreadLocalTest {
    public static void main(String[] args) {

    new Thread(new MyRunnable()).start();
    new Thread(new MyRunnable()).start();

    }
}

class MyRunnable implements Runnable {
    private static final AtomicInteger nextId = new AtomicInteger();

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>();

//    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
////        @Override
////        protected Integer initialValue() {
////            return nextId.getAndAdd(1);
////        }
//    };

    public void run() {
        System.out.println(threadId.get());
    }
}

