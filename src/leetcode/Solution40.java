package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小的k个数(https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)
 * Created by xsg on 2020/8/10.
 */
public class Solution40 {

    /**
     * 排序后取最小 k 个数
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) return new int[0];

        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 使用一个大顶堆
     * 堆顶存储最大的值
     * 当堆中元素大于 k 时，将堆顶元素 poll
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];

        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int n : arr) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            res[index ++] = queue.poll();
        }
        return res;
    }
}
