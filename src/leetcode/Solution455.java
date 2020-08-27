package leetcode;

import java.util.Arrays;

/**、
 * 分发饼干(https://leetcode-cn.com/problems/assign-cookies/)
 * Created by xsg on 2020/8/27.
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int i = 0;
        int j = 0;
        while (i < g.length) {
            while (j < s.length) {
                if (g[i] <= s[j++]) {
                    res ++;
                    break;
                }
            }
            i ++;
        }

        return res;
    }
}
