package designpatterns.singleton;

/**
 * 双重检查
 * Created by xsg on 2019/12/1.
 */
public class DCLSingleton {
    private volatile static DCLSingleton dclSingleton;
    private DCLSingleton() {
        if(null != DCLSingleton.dclSingleton) {
            throw new RuntimeException();
        }
    }

    public DCLSingleton getInstance() {
        if(dclSingleton == null) {
            synchronized (DCLSingleton.class) {
                if(dclSingleton == null) {
                    dclSingleton = new DCLSingleton();
                }
            }
        }
        return dclSingleton;
    }
}
