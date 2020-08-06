package leetcode;

import java.util.*;

/**
 * 字母异位词分组(https://leetcode-cn.com/problems/group-anagrams/)
 * Created by xsg on 2020/8/6.
 */
public class Solution49 {
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
        return new ArrayList(map.values());
    }
}
