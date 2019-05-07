package array;

/**
 * Created by xsg on 2019/5/7.
 */
public class PalindromeBaseArray {
    
    public static void main(String[] args) {
        MyArray myArray = new MyArray(6);
        myArray.addFirst(1);
        myArray.addFirst(2);
        myArray.addFirst(3);
        myArray.addFirst(3);
        myArray.addFirst(2);
        myArray.addFirst(1);

        int size = myArray.getSize();
        
        boolean isPalindrome = true;
        for(int i = 0; i <= size / 2; i++) {
            if(myArray.get(i) != myArray.get(size - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        
        System.out.println(isPalindrome);
    }
    
}
