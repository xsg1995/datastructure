package designpatterns.strategyfactory;

/**
 * Created by xsg on 2019/12/1.
 */
public class Context {
    private Stragegy stragegy;

    public Double calRechrage(Double charge, Integer type) {
        stragegy = StrategyFactory.getInstance().creator(type);
        return stragegy.calRecharge(charge, RechargeTypeEnum.valueOf(type));
    }

    public Stragegy getStragegy() {
        return stragegy;
    }
}
