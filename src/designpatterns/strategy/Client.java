package designpatterns.strategy;

/**
 * Created by xsg on 2019/12/1.
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.contextInterface();
    }
}
