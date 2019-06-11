package algorithm;

/**
 * 基于回溯算法求解八皇后问题
 * Created by xsg on 2019/6/9.
 */
public class EightQueens {

    //数组下标为行，数组值为queue存储在哪一列
    public static int[] result = new int[8];

    /**
     * 计算8皇后的值
     * @param row
     */
    public static void cal8Queens(int row) {
        if(row == 8) {
            printQueens();
            return;
        }
        for(int i = 0; i < 8; i++) {
            if(isOk(row, i)) {
                result[row] = i;
                cal8Queens(row + 1);
            }
        }
    }

    /**
     * 判断行对应的列中的queens是否合法
     * @param row
     * @param column
     * @return
     */
    private static boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;
        for(int i = row - 1; i >= 0; i--) {
            //判断i行上的column是否有queen
            if(result[i] == column) return false;

            //判断左上对角线：第 i 行 leftup 列否有有queen
            if(leftup >= 0) {
                if(result[i] == leftup) return false;
            }

            //判断右上对角线：第 i 行 rightup 列否有有queen
            if(rightup < 8) {
                if(result[i] == rightup) return false;
            }
            leftup --;
            rightup ++;
        }
        return true;
    }

    /**
     * 打印结果
     */
    private static void printQueens() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(result[i] == j) {
                    System.out.print("Q\t");
                } else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        cal8Queens(0);
    }
}
