package concurrencyprogramming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用AtomicReference保证不可变对象的引用原子性
 * Created by xsg on 2019/6/1.
 */
public class SafeCount {

    /**
     * 创建一个不可变类
     */
    final class Count {
        final int count;

        public Count(int count) {
            this.count = count;
        }
    }

    final AtomicReference<Count> rf = new AtomicReference<>(new Count(0));

    /**
     * 往count中添加指定的数
     * @param count
     */
    void addCount(int count) {
        while (true) {
            Count oldCount = rf.get();
            int nc = oldCount.count + count;
            Count newCount = new Count(nc);
            if(rf.compareAndSet(oldCount, newCount)) {
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SafeCount safeCount = new SafeCount();

        ExecutorService executorService =
                Executors.newFixedThreadPool(100);
        for(int i = 1; i <= 100; i++) {
            final int count = i;
            executorService.execute(() -> {
                safeCount.addCount(count);
            });
        }
        Thread.sleep(1000);
        Count count = safeCount.rf.get();
        System.out.println(count.count);
    }
}
