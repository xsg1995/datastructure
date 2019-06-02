package concurrencyprogramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 使用CompletableFuture实现烧水泡茶的例子
 * Created by xsg on 2019/6/2.
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        //异步执行f1
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("t1:洗水壶...");
            sleep(1, TimeUnit.SECONDS);
            System.out.println("t1:烧开水...");
            sleep(15, TimeUnit.SECONDS);
        });
        //异步执行f2
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("t2:洗茶壶...");
            sleep(1, TimeUnit.SECONDS);
            System.out.println("t2:洗茶杯...");
            sleep(2, TimeUnit.SECONDS);
            System.out.println("t2:拿茶叶...");
            sleep(1, TimeUnit.SECONDS);

            return "龙井";
        });

        //f3等待f1与f2执行完再执行
        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("t3:拿到茶叶:" + tf);
            System.out.println("t3:泡茶...");
            return "上茶: " + tf;
        });

        //等待f3执行完毕
        System.out.println(f3.join());
    }

    private static void sleep(int t, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
