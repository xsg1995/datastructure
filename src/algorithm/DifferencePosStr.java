package algorithm;

/**
 * 给定两个字符串s和t，判断t是否是s的字母异位词
 * Created by xsg on 2020/1/12.
 */
public class DifferencePosStr {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = analyze(s, t);
        System.out.println(result);
    }

    private static boolean analyze(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }
        int[] arrays = new int[26];

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            arrays[sChars[i] - 97]++;
            arrays[tChars[i] - 97]--;
        }

        for (int a : arrays) {
            if(a != 0) {
                return false;
            }
        }

        return true;
    }


}
