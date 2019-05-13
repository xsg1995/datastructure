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

    /**
     * 在数组中查找第一个等于给定值的下标
     * @param nums
     * @param value
     * @return
     */
    public static int bSearchFirstEqualValue(int[] nums, int value) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > value) {
                high = mid - 1;
            } else if(nums[mid] < value) {
                low = mid + 1;
            } else {
                if(mid == 0 || nums[mid - 1] != value) return mid;
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 在数组中查找最后一个值等于给定值的下标
     * @param nums
     * @param value
     * @return
     */
    public static int bSearchLastEqualValue(int[] nums, int value) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > value) {
                high = mid - 1;
            } else if(nums[mid] < value) {
                low = mid + 1;
            } else {
                if(mid == high || nums[mid + 1] != value) return mid;

                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 在数组中查找第一个大于等于给定值的元素的下标
     * @param nums
     * @param value
     */
    public static int bSearchFirstLargeValue(int[] nums, int value) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= value) {
                if(mid == 0 || nums[mid - 1] < value) return mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素下标
     * @param nums
     * @param value
     * @return
     */
    public static int bSearchLastSmallerValue(int[] nums, int value) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= value) {
                if(mid == high || nums[mid + 1] > value) return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {1, 2, 3, 4, 5, 6};
//        System.out.println(bSearch(nums, 5));
//        System.out.println(bSearchByRecursion(nums, 5));

        int[] nums = new int[] {1, 2, 2, 3, 4, 5, 6};
//        System.out.println(bSearchFirstEqualValue(nums, 2));
//        System.out.println(bSearchLastEqualValue(nums, 2));
//        System.out.println(bSearchFirstLargeValue(nums, 3));
        System.out.println(bSearchLastSmallerValue(nums, 3));

    }

}
