package leetcode;

import java.util.*;

/**
 * 单词接龙(https://leetcode-cn.com/problems/word-ladder/)
 * Created by xsg on 2020/8/26.
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst(beginWord);
        int step = 1;
        while (!deque.isEmpty()) {
            step ++;
            for (int count = deque.size(); count > 0; count --) {
                String curStr = deque.pollLast();
                char[] curCharArray = curStr.toCharArray();
                for (int i = 0; i < curCharArray.length; i++) {
                    char curChar = curCharArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curCharArray[i] = c;
                        String newStr = new String(curCharArray);
                        if (endWord.equals(newStr)) return step;

                        if (wordSet.contains(newStr)) {
                            deque.offerFirst(newStr);
                            wordSet.remove(newStr);
                        }
                    }
                    curCharArray[i] = curChar;
                }
            }
        }

        return 0;
    }
}
