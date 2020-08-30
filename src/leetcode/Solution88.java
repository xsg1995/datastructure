package leetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组(https://leetcode-cn.com/problems/merge-sorted-array/)
 * Created by xsg on 2020/8/4.
 */
public class Solution88 {

    /**
     * 申请一个新数组
     * 遍历两个有序数组，将值添加到新数组中
     * 将新数组中的值拷贝会旧数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums = new int[m + n];

        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                newNums[index++] = nums1[i++];
            } else {
                newNums[index++] = nums2[j++];
            }
        }
        if (i < m) {
            while (i < m) {
                newNums[index++] = nums1[i++];
            }
        } else if (j < n) {
            while (j < n) {
                newNums[index++] = nums2[j++];
            }
        }
        for (int z = 0; z < newNums.length; z++) {
            nums1[z] = newNums[z];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 将两个数组的数据从尾部取最大值插入到数组中
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = (m + n) - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1 --] : nums2[p2 --];
        }
        for (; p2 >= 0; p2 --) {
            nums1[p --] = nums2[p2];
        }
    }
}
