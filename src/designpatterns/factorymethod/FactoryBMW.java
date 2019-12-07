package designpatterns.factorymethod;

/**
 * 开闭原则，对扩展开放，对修改关闭
 * 当有新的产品时，只要按照抽象产品角色、抽象工厂角色提供的规范来生成，就可以被
 * 客户端使用，不需要修改已有的代码
 * Created by xsg on 2019/12/1.
 */
interface FactoryBMW {
    BMW createBMW();
}
