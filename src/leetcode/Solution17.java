package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合(https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
 * Created by xsg on 2020/8/23.
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");


        helper(0, digits.length(), digits, "", res, map);
        return res;
    }

    private void helper(int index, int n, String digits, String curr, List<String> list, Map<Character, String> map) {
        if (index == n) {
            list.add(curr);
            return;
        }

        char c = digits.charAt(index);
        for (char cc : map.get(c).toCharArray()) {
            helper(index + 1, n, digits, curr + String.valueOf(cc), list, map);
        }
    }
}
