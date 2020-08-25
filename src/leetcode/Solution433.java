package leetcode;

import java.util.*;

/**
 * 最小基因变化(https://leetcode-cn.com/problems/minimum-genetic-mutation/)
 * Created by xsg on 2020/8/25.
 */
public class Solution433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;

        char[] cc = {'A', 'C', 'G', 'T'};
        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst(start);
        int step = 0;
        while (!deque.isEmpty()) {
            step ++;
            for (int count = deque.size(); count > 0; count --) {
                String cur = deque.pollLast();
                char[] oldCharArray = cur.toCharArray();
                for (int i = 0; i < oldCharArray.length; i++) {
                    char oldC = oldCharArray[i];
                    for (char c : cc) {
                        oldCharArray[i] = c;
                        String target = new String(oldCharArray);
                        if (target.equals(end)) return step;
                        if (bankSet.contains(target)) {
                            bankSet.remove(target);
                            deque.offerFirst(target);
                        }
                    }
                    oldCharArray[i] = oldC;
                }
            }
        }

        return -1;
    }
}
