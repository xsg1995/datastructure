package concurrencyprogramming;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CompletionService批量执行异步任务
 * Created by xsg on 2019/6/2.
 */
public class CompletionServiceTest {

    /**
     * 模拟异步日任务执行，获取价格
     * @return
     */
    public static String getPriceByS1() {
        Random random = new Random();
        int time = random.nextInt(10000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "10000";
    }

    /**
     * 模拟异步日任务执行，获取价格
     * @return
     */
    public static String getPriceByS2() {
        Random random = new Random();
        int time = random.nextInt(10000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "1000";
    }

    /**
     * 模拟异步日任务执行，获取价格
     * @return
     */
    public static String getPriceByS3() {
        Random random = new Random();
        int time = random.nextInt(10000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "1100";
    }

    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);

        //创建CompletionService异步执行任务
        CompletionService<String> cs = new ExecutorCompletionService<String>(executorService);
        //提交三个执行任务
        cs.submit(() -> getPriceByS1());
        cs.submit(() -> getPriceByS2());
        cs.submit(() -> getPriceByS3());

        for(int i = 0; i < 3; i++) {
            try {
                //获取执行任务的执行结果
                String s = cs.take().get();
                executorService.execute(() -> System.out.println(s));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
