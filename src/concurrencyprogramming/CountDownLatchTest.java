package concurrencyprogramming;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 练习
 * Created by xsg on 2019/06/05.
 */
public class CountDownLatchTest {

    /**
     * 查账
     * @throws InterruptedException
     */
    public void checkAccount() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        while (MockData.hasOrder()) {
            OrderInfo orderInfo = new OrderInfo();
            CountDownLatch countDownLatch = new CountDownLatch(2);

            executorService.execute(() -> {
                orderInfo.pOrder = MockData.getPOrder();
                countDownLatch.countDown();
            });

            executorService.execute(() -> {
                orderInfo.dOrder = MockData.getDOrder();
                countDownLatch.countDown();
            });

            countDownLatch.await();

            check(orderInfo);
        }
    }

    /**
     * 查账
     * @param orderInfo
     */
    private void check(OrderInfo orderInfo) {
        System.out.println(orderInfo.pOrder + "   " + orderInfo.dOrder);
    }

    public class OrderInfo {
        public String pOrder;
        public String dOrder;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTest test = new CountDownLatchTest();
        test.checkAccount();
    }
}
