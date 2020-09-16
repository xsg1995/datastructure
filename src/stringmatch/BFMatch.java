package stringmatch;

/**
 * 暴力匹配字符串算发
 * Created by xsg on 2019/5/23.
 */
public class BFMatch {

    public static void main(String[] args) {
        String mainStr = "baabcdabc";
        String matchStr = "abc";
        System.out.println(match(mainStr, matchStr));
    }

    /**
     * 在主串中查找子串
     * @param mainStr 主串
     * @param matchStr 子串
     * @return 子串在主串的位置
     */
    private static int match(String mainStr, String matchStr) {
        int n = mainStr.length();
        int m = matchStr.length();
        if(n < m) return -1;

        int i = 0;
        while (i <= (n - m)) {
            int j = 0;
            for(; j < m; j++) {
                if(mainStr.charAt(j + i) != matchStr.charAt(j)) {
                    break;
                }
            }
            if(j == m) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
