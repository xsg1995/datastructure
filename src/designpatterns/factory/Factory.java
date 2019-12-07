package designpatterns.factory;

/**
 * 工厂类角色
 * Created by xsg on 2019/12/1.
 */
public class Factory {
    public BMW createBMW(int type) {
        switch (type) {

            case 320:
                return new BMW320();
            case 523:
                return new BMW523();
            default:
                break;
        }
        return null;
    }
}
