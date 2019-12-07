package designpatterns.strategyfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xsg on 2019/12/1.
 */
public class StrategyFactory {

    private static StrategyFactory factory = new StrategyFactory();

    private StrategyFactory() {
    }

    private static Map<Integer, Stragegy> stragegyMap = new HashMap<>();

    static {
        stragegyMap.put(RechargeTypeEnum.E_BANK.getValue(), new EBankStrategy());
        stragegyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.getValue(), new BusiAcctStrategy());
        stragegyMap.put(RechargeTypeEnum.MOBILE.getValue(), new MobileStrategy());
    }

    public Stragegy creator(Integer type) {
        return stragegyMap.get(type);
    }

    public static StrategyFactory getInstance() {
        return factory;
    }
}
