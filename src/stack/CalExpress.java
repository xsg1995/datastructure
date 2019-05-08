package stack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xsg on 2019/5/8.
 */
public class CalExpress {

    public static Map<String, Integer> expMap = new HashMap<>();

    static {
        expMap.put("+", 1);
        expMap.put("-", 1);
        expMap.put("*", 2);
        expMap.put("/", 2);
    }

    public static double cal(String express) {
        MyStack<Double> numStack = new MyStack<>();
        MyStack<String> expStack = new MyStack<>();

        if(express == null && express.trim().equals("")) {
            return -1;
        }

        String[] split = express.split(" ");
        for (String s : split) {
            Integer curExpValue = expMap.get(s);
            if(curExpValue != null) {
                //操作数
                String exp = expStack.offer();
                if(exp == null) {
                    expStack.push(s);
                } else {
                    Integer pExpValue = expMap.get(exp);
                    if(curExpValue > pExpValue) {
                        expStack.push(s);
                    } else {
                        exp = expStack.pop();
                        Double second = numStack.pop();
                        Double first = numStack.pop();
                        Double value = calValue(first, second, exp);
                        numStack.push(value);
                        expStack.push(s);
                    }
                }


            } else {
                //数字
                numStack.push(Double.parseDouble(s));
            }
        }
        while (expStack.offer() != null) {
            Double second = numStack.pop();
            Double first = numStack.pop();
            Double value = calValue(first, second, expStack.pop());
            numStack.push(value);
        }

        return numStack.pop();
    }

    private static Double calValue(Double v1, Double v2, String exp) {
        Double value = null;
        switch (exp) {
            case "+" :
                value = v1 + v2;
                break;
            case "-" :
                value = v1 - v2;
                break;
            case "*" :
                value = v1 * v2;
                break;
            case "/" :
                value = v1 / v2;
                break;
        }
        return value;
    }

    public static void main(String[] args) {
        String express = "1 + 1 * 2 - 3 + 10 / 5 * 4 + 8 - 2 * 5";
        System.out.println(cal(express));
    }

}