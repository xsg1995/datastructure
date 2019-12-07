package designpatterns.strategyfactory;

/**
 * Created by xsg on 2019/12/1.
 */
public class BusiAcctStrategy implements Stragegy {
    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge * 0.9;
    }
}
