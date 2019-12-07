package designpatterns.factorymethod;

/**
 * Created by xsg on 2019/12/1.
 */
public class FactoryBMW320 implements FactoryBMW {

    @Override
    public BMW createBMW() {
        return new BMW320();
    }
}
