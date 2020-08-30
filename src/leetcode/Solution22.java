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

    /**
     * left 放入的左括号的数量 right 放入的右括号的数量
     * left == right == n 则放入的左、右括号都已达到上限
     * left < n 则左括号未放满，可以继续放入左括号
     * right < left，则可以继续放入右括号
     */
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

    /**
     * 左右括号共有 2n 个位置
     * 每个位置都可以放入左、右括号
     * 放入每个括号后，使用 dfs 继续放入下一个位置的括号
     * 最后当 2n 个位置都填满后，验证生成的括号是否有效
     */
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
