package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by liqiulin on 2017/9/8.
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            return 100;
        });

        // join与get抛出不同的异常
        future.join();
//        future.get();
    }
}
