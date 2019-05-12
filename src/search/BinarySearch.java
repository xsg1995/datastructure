package search;

/**
 * Created by xsg on 2019/5/12.
 */
public class BinarySearch {

    /**
     * 非递归实现
     * @param nums
     * @param value
     * @return
     */
    public static int bSearch(int[] nums, int value) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == value) {
                return mid;
            } else if(nums[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 递归实现
     * @param nums
     * @param value
     * @return
     */
    public static int bSearchByRecursion(int[]nums, int value) {
        return bSearchByRecursion(nums, 0, nums.length - 1, value);
    }

    private static int bSearchByRecursion(int[] nums, int low, int high, int value) {
        if(low > high) return -1;

        int mid = low + (high - low) / 2;
        if(nums[mid] == value) {
            return mid;
        } else if(nums[mid] > value) {
            return bSearchByRecursion(nums, low, mid - 1, value);
        } else {
            return bSearchByRecursion(nums, mid + 1, high, value);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6};
//        System.out.println(bSearch(nums, 5));
        System.out.println(bSearchByRecursion(nums, 5));
    }
}
