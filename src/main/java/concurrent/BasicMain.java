package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <a href="http://colobu.com/2016/02/29/Java-CompletableFuture/" >Java CompletableFuture 详解</a>
 *
 * Created by liqiulin on 2017/9/8.
 */
public class BasicMain {
    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;
    }
    public static void main(String[] args) throws Exception {
        final CompletableFuture<Integer> f = compute();
        class Client extends Thread {
            CompletableFuture<Integer> f;
            Client(String threadName, CompletableFuture<Integer> f) {
                super(threadName);
                this.f = f;
            }
            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + f.get());  // 这里会阻塞，直到能f能get到值
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        new Client("Client1", f).start();
        new Client("Client2", f).start();
        System.out.println("waiting");
        f.complete(100);   //  给f设置一个complete值
        //f.completeExceptionally(new Exception());
        System.in.read();
    }
}