package array;

/**
 * 基于数组实现回文串的判断
 * Created by xsg on 2019/5/7.
 */
public class PalindromeBaseArray {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1};
        
        boolean isPalindrome = true;
        for(int i = 0; i < nums.length / 2; i++) {
            if (nums[i] != nums[nums.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        
        System.out.println(isPalindrome);
    }
    
}
