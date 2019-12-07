package designpatterns.strategyfactory;

/**
 * Created by xsg on 2019/12/1.
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        // 网银充值100 需要付多少
        Double money = context.calRechrage(100D, RechargeTypeEnum.E_BANK.getValue());
        System.out.println(money);

        // 商户账户充值100 需要付多少
        Double money2 = context.calRechrage(100D, RechargeTypeEnum.BUSI_ACCOUNTS.getValue());
        System.out.println(money2);

        // 手机充值100 需要付多少
        Double money3 = context.calRechrage(100D, RechargeTypeEnum.MOBILE.getValue());
        System.out.println(money3);
    }
}
