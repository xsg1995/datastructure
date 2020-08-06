package leetcode;

/**
 * 加一(https://leetcode-cn.com/problems/plus-one/)
 * Created by xsg on 2020/8/4.
 */
public class Solution66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] ++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
