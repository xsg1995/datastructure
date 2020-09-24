package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符(https://leetcode-cn.com/problems/first-unique-character-in-a-string/)
 * Created by xsg on 2020/9/24.
 */
public class Solution387 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        char[] cc = s.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            boolean uniq = true;
            for (int j = 0; j < cc.length; j++) {
                if (i == j) continue;

                if (cc[i] == cc[j]) {
                    uniq = false;
                    break;
                }
            }
            if (uniq) return i;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return -1;

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }
}
