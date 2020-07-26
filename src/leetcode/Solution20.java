package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效的括号(https://leetcode-cn.com/problems/valid-parentheses/)
 * Created by xsg on 2020/7/26.
 */
public class Solution20 {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;

        Deque<Character> deque = new LinkedList<>();
        char[] cs = s.toCharArray();
        for (char c : cs ) {
            if (c == '(') {
                deque.addLast(')');
            } else if (c == '{') {
                deque.addLast('}');
            } else if (c == '[') {
                deque.addLast(']');
            } else {
                if (deque.isEmpty() || deque.pollLast() != c) return false;
            }
        }
        return deque.isEmpty();
    }
}
