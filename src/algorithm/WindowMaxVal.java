package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 滑动窗口最大值
 * Created by xsg on 2020/1/12.
 */
public class WindowMaxVal {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int startIdx = 0;
        int endIdx = k - 1;

        Deque<NumObj> deque = new ArrayDeque<>();

        List<Integer> result = new ArrayList<>();

        while (endIdx < nums.length) {

            for(int i = startIdx; i <= endIdx; i++) {
                if(deque.isEmpty()) {
                    deque.add(new NumObj(i, nums[i]));
                } else {
                    if(nums[i] < deque.peekLast().val) {
                        deque.addLast(new NumObj(i, nums[i]));
                        continue;
                    }

                    while (!deque.isEmpty() && (nums[i] > deque.peekLast().val || deque.peekLast().index < startIdx)) {
                        deque.removeLast();
                    }
                    deque.addLast(new NumObj(i, nums[i]));
                }
            }
            result.add(deque.peekFirst().val);

            startIdx ++;
            endIdx ++;
        }

        System.out.println(result);
    }

    static class NumObj {
        public int index;
        public int val;

        public NumObj(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

}
