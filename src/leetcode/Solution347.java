package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素(https://leetcode-cn.com/problems/top-k-frequent-elements/)
 * Created by xsg on 2020/8/10.
 */
public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

}
