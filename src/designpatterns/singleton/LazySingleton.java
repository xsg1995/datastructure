package designpatterns.singleton;

/**
 * 懒汉模式
 * Created by xsg on 2019/12/1.
 */
public class LazySingleton {

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        return Holder.SINGLE_TON;
    }

    private static class Holder {
        private static final LazySingleton SINGLE_TON = new LazySingleton();
    }
}
