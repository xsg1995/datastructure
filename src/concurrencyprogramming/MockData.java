package concurrencyprogramming;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by xsg on 2019/06/05.
 */
public class MockData {

    public static ArrayBlockingQueue<String> pOrders = new ArrayBlockingQueue<String>(10);
    public static ArrayBlockingQueue<String> dOrders = new ArrayBlockingQueue<String>(10);

    static {
        try {
            pOrders.put("订单1");
            pOrders.put("订单2");
            pOrders.put("订单3");
            pOrders.put("订单4");
            pOrders.put("订单5");
            pOrders.put("订单6");
            pOrders.put("订单7");
            pOrders.put("订单8");
            pOrders.put("订单9");
            pOrders.put("订单10");

            dOrders.put("派送订单1");
            dOrders.put("派送订单2");
            dOrders.put("派送订单3");
            dOrders.put("派送订单4");
            dOrders.put("派送订单5");
            dOrders.put("派送订单6");
            dOrders.put("派送订单7");
            dOrders.put("派送订单8");
            dOrders.put("派送订单9");
            dOrders.put("派送订单10");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取模拟订单数据
     * @return
     */
    public static String getPOrder() {
        return pOrders.poll();
    }

    /**
     * 获取模拟订单数据
     * @return
     */
    public static String getDOrder() {
        return dOrders.poll();
    }

    /**
     * 是否存在未处理订单
     * @return
     */
    public static boolean hasOrder() {
        return !pOrders.isEmpty();
    }
}
