package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 假如有n个台阶，每次可以跨1个台阶或者2个台阶，走完这n个台阶有多少种走法？
 * Created by xsg on 2019/5/10.
 */
public class OneOrTowStep {

    public static Map<Integer, Integer> stepMap = new HashMap<>();

    /**
     * 递归求解
     * @param step
     * @return
     */
    public static int count(int step) {
        if(step == 1) return 1;
        if(step == 2) return 2;

        if(stepMap.containsKey(step)) {
            return stepMap.get(step);
        }

        int ret = count(step - 1) + count(step - 2);
        stepMap.put(step, ret);

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(count(10));
    }

}
