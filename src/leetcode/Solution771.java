package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 宝石与石头(https://leetcode-cn.com/problems/jewels-and-stones/)
 * Created by xsg on 2020/9/22.
 */
public class Solution771 {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char s : S.toCharArray()) {
            for (char j : J.toCharArray()) {
                if (s == j) {
                    count ++;
                    break;
                }
            }
        }
        return count;
    }

    public int numJewelsInStones2(String J, String S) {
        int count = 0;
        Map<Character, Character> map = new HashMap<>();
        for (char c : J.toCharArray()) {
            map.put(c, c);
        }
        for (char c : S.toCharArray()) {
            if (map.containsKey(c)) count ++;
        }
        return count;
    }
}
