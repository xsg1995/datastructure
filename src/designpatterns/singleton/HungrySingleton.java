package designpatterns.singleton;


/**
 * 饿汉模式
 * Created by xsg on 2019/12/1.
 */
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
