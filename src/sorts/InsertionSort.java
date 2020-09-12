package sorts;

/**
 * 插入排序
 * Created by xsg on 2019/5/10.
 */
public class InsertionSort {

    /**
     * 插入排序
     * @param nums
     */
    public static void insertionSort(int[] nums) {
        if(nums.length <= 1) return;

        for(int i = 1; i < nums.length; i++) {
            int insertNum = nums[i];
            int j = i - 1;
            for(; j >= 0; j--) {
                if(nums[j] > insertNum) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = insertNum;
        }
    }

}
