package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by liqiulin on 2017/9/8.
 */
public class BasicFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> f = executorService.submit(() -> {
            Thread.sleep(100);
            return 100;
        });

        // 判断是否完成
        while (!f.isDone()) {
            System.out.println("none done!");
            Thread.sleep(1);
        }
        // 获取结果
        int result = f.get();
        System.out.println(result);


         f = executorService.submit(() -> {
             return 1/0;
        });
        while (!f.isDone()) {
            System.out.println("none done!");
            Thread.sleep(1);
        }
        result = f.get();  // 这里会抛异常
    }
}
