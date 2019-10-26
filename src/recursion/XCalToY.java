package recursion;

/**
 * X 乘 2 或者 X 减 1 等于 Y
 * Created by xsg on 2019/10/26.
 */
public class XCalToY {

    public static void main(String[] args) {
        int x = 3;
        int y = 8;
        int result = cal(x, y);
        System.out.println(result);
    }

    public static int cal(int x, int y) {
        if(x == y) return 0;

        if(x > y) {
            return cal(x - 1, y) + 1;
        } else {
            return cal(x * 2, y) + 1;
        }
    }

}
