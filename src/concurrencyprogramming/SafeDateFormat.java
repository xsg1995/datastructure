package concurrencyprogramming;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用ThreadLocal解决SimpleDateFormat在并发场景下是线程安全的
 * Created by xsg on 2019/6/1.
 */
public class SafeDateFormat {

    //定义ThreadLocal
    public static final ThreadLocal<DateFormat> tl =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    /**
     * 获取DateFormat
     * @return
     */
    public static DateFormat get() {
        return tl.get();
    }

    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                DateFormat dateFormat = get();
                try {
                    Date date = dateFormat.parse("2019-06-01 20:02:40");
                    System.out.println(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                } finally {
                    //是否ThreadLocal资源
                    tl.remove();
                }
            });
        }
    }
}
