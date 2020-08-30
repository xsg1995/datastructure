package leetcode;

/**
 * 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
 * Created by xsg on 2020/8/29.
 */
public class ChangeSolution33 {

    public static void main(String[] args) {
        ChangeSolution33 solution17 = new ChangeSolution33();
        System.out.println(solution17.find(new int[] {4, 5, 6, 7, 0, 1, 2}));
    }

    public int find(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

//二分法取中间的值(a)与最后一个值(b)进行比较
//a >= b 则无序的部分在 a 后面，因此left = mid + 1
//a < b 则 a 处于无序部分，因此 right = mid
//当 left == right ，则 left = right = 无序的索引
//注意：left < right，left <= right 会有死循环