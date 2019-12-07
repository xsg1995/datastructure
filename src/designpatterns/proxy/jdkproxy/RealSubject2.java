package designpatterns.proxy.jdkproxy;

/**
 * Created by xsg on 2019/12/2.
 */
public class RealSubject2 implements Subject {
    @Override
    public void request() {
        System.out.println("realSubject2...");
    }
}
