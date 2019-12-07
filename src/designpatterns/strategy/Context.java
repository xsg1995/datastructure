package designpatterns.strategy;

/**
 * 封装角色
 * Created by xsg on 2019/12/1.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.algorithmLogic();
    }
}
