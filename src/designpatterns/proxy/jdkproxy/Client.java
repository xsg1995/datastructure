package designpatterns.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * Created by xsg on 2019/12/2.
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        DynamicProxy proxy = new DynamicProxy(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), proxy);
        subject.request();

//        RealSubject2 realSubject2 = new RealSubject2();
//        DynamicProxy proxy2 = new DynamicProxy(realSubject2);
//        Subject subject2 = (Subject) Proxy.newProxyInstance(RealSubject2.class.getClassLoader(), RealSubject2.class.getInterfaces(), proxy2);
//        subject2.request();
    }
}
