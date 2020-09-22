package leetcode;

/**
 * 最后一个单词的长度(https://leetcode-cn.com/problems/length-of-last-word/)
 * Created by xsg on 2020/9/22.
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;

        String[] split = s.trim().split(" ");
        String lastWord = split[split.length - 1];
        return lastWord.length();
    }

    public int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) return 0;

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count ++;
        }
        return count;
    }

    public int lengthOfLastWord3(String s) {
        if (s == null || s.length() == 0) return 0;

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end --;

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start --;

        return end - start;
    }
}
