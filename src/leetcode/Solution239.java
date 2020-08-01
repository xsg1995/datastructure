package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值(https://leetcode-cn.com/problems/sliding-window-maximum/)
 * Created by xsg on 2020/8/1.
 */
public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) return new int[0];

        int len = nums.length - k + 1;
        int[] res = new int[len];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            int start = i - k;
            if (start >= 0) {
                queue.remove(nums[start]);
            }
            queue.offer(nums[i]);
            if (queue.size() == k) {
                res[start + 1] = queue.peek();
            }
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < k) return new int[0];

        int len = nums.length - k + 1;
        int[] res = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int start = i - k + 1;
            while (!deque.isEmpty() && deque.peekFirst() < start) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (start >= 0) {
                res[start] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
