package leetcode;

/**
 * 加一(https://leetcode-cn.com/problems/plus-one/)
 * Created by xsg on 2020/8/4.
 */
public class Solution66 {

    /**
     * 每一位的范围：0 ~ 9
     * 当当前位的值为 9 时，+1 后为 10
     * 10 % 10 = 0
     * 结果为 0 时需要进位 +1
     * 如果进位 +1 后最高位为 0
     * 则整体进位，例如 99 + 1 = 100
     */
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
