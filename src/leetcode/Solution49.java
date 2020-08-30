package leetcode;

import java.util.*;

/**
 * 字母异位词分组(https://leetcode-cn.com/problems/group-anagrams/)
 * Created by xsg on 2020/8/6.
 */
public class Solution49 {
    /**
     * 每个字符串的 hash 值相同，则是同组异位词
     * 计算唯一 hash 值
     * char[] ccs = new char[26];
     * 存储每个 char 出现的次数
     * String key = new String(ccs) 唯一
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            char[] ccs = new char[26];
            for (char c : cs) ccs[c - 'a'] ++;
            String key = new String(ccs);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
