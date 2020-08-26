package leetcode;

/**
 * 柠檬水找零(https://leetcode-cn.com/problems/lemonade-change/)
 * Created by xsg on 2020/8/26.
 */
public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int b : bills) {
            if (b == 5) {
                five ++;
            } else if (b == 10) {
                if (five > 0) {
                    five --;
                    ten ++;
                } else {
                    return false;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five --;
                    ten --;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
