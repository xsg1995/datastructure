package designpatterns.proxy.staticproxy;

/**
 * 代理对象
 * Created by xsg on 2019/12/2.
 */
public class ProxySubject implements Subject {

    private Subject realSubject;

    public ProxySubject(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("preRequest...");
        this.realSubject.request();
        System.out.println("afterRequest...");
    }
}
