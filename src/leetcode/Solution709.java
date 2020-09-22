package leetcode;

/**
 * 转换成小写字母(https://leetcode-cn.com/problems/to-lower-case/)
 * Created by xsg on 2020/9/22.
 */
public class Solution709 {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return null;

        char[] cc = str.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] >= 'A' && cc[i] <= 'Z') {
                cc[i] = (char) (cc[i] + 32);
            }
        }
        return new String(cc);
    }

    public String toLowerCase2(String str) {
        if (str == null || str.length() == 0) return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
