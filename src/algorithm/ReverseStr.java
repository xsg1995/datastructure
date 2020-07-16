package algorithm;

/**
 * 字符串翻转
 * Created by xsg on 2020/1/12.
 */
public class ReverseStr {
    public static void main(String[] args) {
        String origStr = "algorithm";
        char[] origChars = origStr.toCharArray();
        int headIndex = 0;
        int tailIndex = origChars.length - 1;
        while (headIndex < tailIndex) {

            char headChar = origChars[headIndex];
            origChars[headIndex] = origChars[tailIndex];
            origChars[tailIndex] = headChar;

            headIndex++;
            tailIndex--;
        }

        String reverseStr = new String(origChars);
        System.out.println(reverseStr);
    }
}
