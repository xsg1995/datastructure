package algorithm;

import java.util.Arrays;


/**
 * Created by xsg on 2020/1/26.
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 7, 9, 5, 8};
//        bubbleSort(nums);
//        insertionSort(nums);
//        mergeSort(nums, 0, nums.length - 1);
        quickSort(nums, 0, nums.length -1);

        Arrays.stream(nums).forEach(num -> System.out.print(num));
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if(lo >= hi) return;

        int p = partition(nums, lo, hi);

        quickSort(nums, lo, p - 1);
        quickSort(nums, p + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];

        int i = lo;
        for(int j = lo; j < hi; j ++) {
            if(nums[j] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        int tmp = nums[i];
        nums[i] = nums[hi];
        nums[hi] = tmp;
        return i;
    }

    private static void mergeSort(int[] nums, int lo, int hi) {
        if(lo >= hi) return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);

        merge(nums, lo, mid, hi);
    }

    private static void merge(int[] nums, int lo, int mid, int hi) {
        int[] copy = new int[hi - lo + 1];
        int i = lo;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= hi) {
            if(nums[i] <= nums[j]) {
                copy[k++] = nums[i++];
            } else {
                copy[k++] = nums[j++];
            }
        }

        int start = i;
        int end = mid;
        if(j <= hi) {
            start = j;
            end = hi;
        }
        for(; start <= end; start++) {
            copy[k++] = nums[start];
        }

        for(i = 0; i < copy.length; i++) {
            nums[lo + i] = copy[i];
        }
    }

    private static void insertionSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int j = i - 1;
            for(; j >= 0; j--) {
                if(nums[j] > current) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = current;
        }
    }

    private static void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            boolean hasChange = false;
            for(int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j + 1]) {
                    nums[j] = nums[j] + nums[j + 1];
                    nums[j + 1] = nums[j] - nums[j + 1];
                    nums[j] = nums[j] - nums[j + 1];
                    hasChange = true;
                }
            }
            if(!hasChange) {
                break;
            }
        }
    }
}
