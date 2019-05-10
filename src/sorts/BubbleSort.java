package sorts;

import java.util.Arrays;

/**
 * Created by xsg on 2019/5/10.
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort(int[] nums) {

        if(nums.length <= 1) return;

        for(int i = 0; i < nums.length; i++) {
            //用于判断本次比较是否有交换元素
            boolean flag = false;
            for(int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            //没有交换说明已经是有序的
            if(!flag) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {9, 10, 12, 1, 2, 3, 4, 6, 1};
        bubbleSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
