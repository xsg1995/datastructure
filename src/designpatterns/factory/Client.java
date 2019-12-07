package designpatterns.factory;

/**
 * Created by xsg on 2019/12/1.
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);
    }
}
