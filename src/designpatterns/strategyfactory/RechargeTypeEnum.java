package designpatterns.strategyfactory;

/**
 * Created by xsg on 2019/12/1.
 */
public enum  RechargeTypeEnum {
    E_BANK(1, "网银"),
    BUSI_ACCOUNTS(2, "商户账号"),
    MOBILE(3,"手机卡充值"),
    CARD_RECHARGE(4,"充值卡")
    ;

    private int value;
    private String desc;

    RechargeTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static RechargeTypeEnum valueOf(int value) {
        for(RechargeTypeEnum type : RechargeTypeEnum.values()) {
            if(type.value == value) {
                return type;
            }
        }
        return E_BANK;
    }
}
