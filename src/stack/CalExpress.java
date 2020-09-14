package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 表达式求值
 * 用两个栈实现
 * 一个栈存储操作数
 * 一个栈存储操作符
 * 如果当前操作符 > 栈顶操作符，则当前操作符入栈
 * 如果当前操作符 <= 栈顶操作符，则取出从操作数栈取出两个操作数和栈顶操作符进行运算后结果重新入栈
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
        Stack<Double> numStack = new Stack<>();
        Stack<String> expStack = new Stack<>();

        if(express == null || express.trim().equals("")) {
            return -1;
        }

        String[] split = express.split(" ");
        for (String s : split) {
            Integer curExpValue = expMap.get(s);
            if(curExpValue != null) {
                //操作数
                if (expStack.isEmpty()) {
                    expStack.push(s);
                    continue;
                }

                String exp = null;
                while (!expStack.isEmpty() && (exp = expStack.peek()) !=null) {
                    Integer pExpValue = expMap.get(exp);

                    if (curExpValue > pExpValue) break;

                    Double second = numStack.pop();
                    Double first = numStack.pop();
                    Double value = calValue(first, second, expStack.pop());
                    numStack.push(value);
                }

                expStack.push(s);
            } else {
                //数字
                numStack.push(Double.parseDouble(s));
            }
        }
        while (!expStack.isEmpty()) {
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
        String express = "1 + 1 * 2 - 3 + 10 / 5 * 4 + 8 - 2 * 5";  // 6
        System.out.println(cal(express));
    }

}