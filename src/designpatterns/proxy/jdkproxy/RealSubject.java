package designpatterns.proxy.jdkproxy;

/**
 * 真实角色
 * Created by xsg on 2019/12/2.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject...");
    }
}
