package concurrencyprogramming;

import java.util.concurrent.*;

/**
 * 使用FutureTask实现烧水泡茶的例子
 * Created by xsg on 2019/6/3.
 */
public class FutureTaskTest {

    /**
     * T1Task执行步骤：洗水壶、烧开水、泡茶
     */
    static class T1Task implements Callable<String> {

        FutureTask<String> ft2;

        public T1Task(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {
            System.out.println("T1:洗水壶...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("T1:烧开水...");
            TimeUnit.SECONDS.sleep(15);
            String ft = this.ft2.get();
            System.out.println("T1:拿到茶叶:" + ft);

            System.out.println("T1:泡茶...");
            return "上茶：" + ft;
        }
    }

    /**
     * T2Task执行步骤:洗茶壶、洗茶杯、拿茶叶
     */
    static class T2Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("T2：洗茶壶...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("T2:洗茶杯...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("T2:拿茶叶...");
            TimeUnit.SECONDS.sleep(1);
            return "龙井";
        }
    }

    public static void main(String[] args) throws Exception {

        FutureTask<String> ft2 = new FutureTask<String>(new T2Task());
        FutureTask<String> ft1 = new FutureTask<String>(new T1Task(ft2));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(ft1);
        executorService.execute(ft2);

//        new Thread(ft2).start();
//        new Thread(ft1).start();

        System.out.println(ft1.get());
    }
}
