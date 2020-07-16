package algorithm;

import java.util.*;

/**
 * 有序括号，只包含(){}[]
 * Created by xsg on 2020/1/12.
 */
public class BracketsMatch {

    private static Map<String, Integer> leftMap = new HashMap<>();
    private static Map<String, Integer> rightMap = new HashMap<>();

    static {
        leftMap.put("{", 1);
        leftMap.put("[", 2);
        leftMap.put("(", 3);

        rightMap.put("}", 1);
        rightMap.put("]", 2);
        rightMap.put(")", 3);
    }

    public static void main(String[] args) {
        String[] brackets = new String[] {"{", "{", "[", "]", "(", ")", "}", "}"};
        boolean result = analyze(brackets);
        System.out.println(result);
    }

    private static boolean analyze(String[] brackets) {

        Stack<String> stack = new Stack<>();
        for (String s : brackets) {
            if(isLeft(s)) {
                stack.push(s);
            } else {
                String item = stack.pop();
                if(!match(item, s)) {
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private static boolean isLeft(String str) {
        return leftMap.containsKey(str);
    }

    private static boolean match(String left, String right) {
        if(leftMap.get(left).intValue() == rightMap.get(right).intValue()) {
            return true;
        }

        return false;
    }

}
