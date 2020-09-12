package sorts;

/**
 * 冒泡排序
 * Created by xsg on 2019/5/10.
 */
public class BubbleSort {

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] nums) {
        if(nums.length <= 1) return;

        for(int i = 0; i < nums.length; i++) {
            //用于判断本次比较是否有交换元素
            boolean change = false;
            for(int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    change = true;
                }
            }
            //没有交换说明已经是有序的
            if(!change) {
                break;
            }
        }
    }

}
