package concurrencyprogramming;

import java.util.Vector;
import java.util.concurrent.*;

/**
 * CyclicBarrier练习
 * Created by xsg on 2019/06/05.
 */
public class CyclicBarrierTest {

    private Vector<String> dOrders = new Vector<>();
    private Vector<String> pOrders = new Vector<>();

    private ExecutorService oneExecutorService = Executors.newFixedThreadPool(1);

    /**
     * 查账
     * @throws InterruptedException
     */
    public void checkAccount() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> check());

        executorService.execute(() -> {
            while (MockData.hasOrder()) {
                String pOrder = MockData.getPOrder();
                pOrders.add(pOrder);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(() -> {
            while (MockData.hasOrder()) {
                String dOrder = MockData.getDOrder();
                dOrders.add(dOrder);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 查账
     */
    private void check() {
        oneExecutorService.execute(() -> {
            String dOrder = dOrders.remove(0);
            String pOrder = pOrders.remove(0);
            System.out.println(dOrder + "   " + pOrder);
        });
    }

    public static void main(String[] args) {
        CyclicBarrierTest test = new CyclicBarrierTest();
        test.checkAccount();
    }
}
