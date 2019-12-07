package designpatterns.proxy.staticproxy;

/**
 * Created by xsg on 2019/12/2.
 */
public class Client {
    public static void main(String[] args) {
        ProxySubject proxy = new ProxySubject(new RealSubject());
        proxy.request();
    }
}
