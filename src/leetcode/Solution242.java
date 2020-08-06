package leetcode;

import java.util.Arrays;

/**
 * 有效的字母异位词(https://leetcode-cn.com/problems/valid-anagram/)
 * Created by xsg on 2020/8/6.
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a'] ++;
            a[t.charAt(i) - 'a'] --;
        }

        for (int n : a) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }
}
