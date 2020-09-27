package leetcode;

/**
 * 字符串转换整数 (atoi)（https://leetcode-cn.com/problems/string-to-integer-atoi/）
 * Created by xsg on 2020/9/24.
 */
public class Solution8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;

        str = str.trim();
        boolean start = false;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ((c >= '0' && c <= '9')) {
                if (!start) start = true;

                sb.append(c);
            } else if (c == '-') {
                if (start) break;

                sb.append(c);
                start = true;
            } else if (c == '+') {
                if (start) break;

                sb.append(c);
                start = true;
            } else {
                break;
            }
        }
        if (!start) return 0;

        String result = sb.toString();
        if ("-".equals(result) || "+".equals(result)) {
            return 0;
        }

        try {
            return Integer.parseInt(result);
        } catch(Exception e) {
            if (result.startsWith("-"))
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }

}
