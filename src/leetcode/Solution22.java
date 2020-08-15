package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成(https://leetcode-cn.com/problems/generate-parentheses/)
 * Created by xsg on 2020/8/12.
 */
public class Solution22 {

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper2(0, 0, n, "", res);
        return res;
    }

    private void helper2(int left, int right, int n, String str, List<String> list) {
        if (left == n && right == n) {
            list.add(str);
            return;
        }
        if (left < n) {
            helper2(left + 1, right, n, str + "(", list);
        }

        if (right < left) {
            helper2(left, right + 1, n, str + ")", list);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0) return res;

        helper(0, n * 2, "", res);
        return res;
    }

    private void helper(int index, int n, String curStr, List<String> list) {
        if (index == n) {
            boolean valid = validate(curStr);
            if (valid) {
                list.add(curStr);
            }
            return;
        }

        helper(index + 1, n, curStr + "(", list);
        helper(index + 1, n, curStr + ")", list);
    }

    private boolean validate(String str) {
        int res = 0;
        char[] cs = str.toCharArray();
        for (char c : cs) {
            if (c == '(') res ++;
            if (c == ')') res --;

            if (res < 0) return false;
        }
        return res == 0;
    }
}
