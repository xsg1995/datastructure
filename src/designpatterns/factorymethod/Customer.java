package designpatterns.factorymethod;

/**
 * Created by xsg on 2019/12/1.
 */
public class Customer {
    public static void main(String[] args) {
        FactoryBMW factoryBMW320 = new FactoryBMW320();
        BMW bmw320 = factoryBMW320.createBMW();

        FactoryBMW factoryBMW523 = new FactoryBMW523();
        BMW bmw523 = factoryBMW523.createBMW();
    }
}
