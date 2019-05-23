package stringmatch;

/**
 * Created by xsg on 2019/5/23.
 */
public class RKMatch {

    public static void main(String[] args) {
        String mainStr = "baabcdabc";
        String matchStr = "abc";
        System.out.println(match(mainStr, matchStr));

    }

    /**
     * 在主串中查找子串
     * @param mainStr
     * @param matchStr
     * @return
     */
    private static int match(String mainStr, String matchStr) {
        int n = mainStr.length();
        int m = matchStr.length();
        if(n < m) return -1;

        int hM = hash(matchStr);
        int i = 0;
        while (i <= (n - m)) {
            String subStr = mainStr.substring(i, (i + m));
            int hS = hash(subStr);
            if(hM == hS) {
                int j = 0;
                for (; j < m; j++) {
                    if (subStr.charAt(j) != matchStr.charAt(j)) {
                        break;
                    }
                }
                if(j == m) {
                    return i;
                }
            }
            i++;
        }

        return -1;
    }

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
