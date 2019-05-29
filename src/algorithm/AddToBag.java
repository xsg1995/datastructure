package algorithm;

/**
 * 将一组不同重量的物品装入背包，求在满足背包最大重量限制的前提下，背包中物品总重量的最大值
 * Created by xsg on 2019/5/29.
 */
public class AddToBag {
    //存放最大重量
    private static int maxWeight = Integer.MIN_VALUE;
    //物品重量
    private static int[] goodWeights = {2, 2, 4, 6, 3};
    //物品数量
    private static int n = goodWeights.length;
    //背包的最大重量
    private static int bagWeight = 9;
    //存放已经计算过的值
    private static boolean[][] mem = new boolean[n][bagWeight + 1];
    /**
     * 回溯算法实现
     * @param i
     * @param cw
     */
    public static void cal(int i, int cw) {
        if(cw >= bagWeight || i == n) {
            if(cw > maxWeight) {
                maxWeight = cw;
            }
            return;
        }

        if(mem[i][cw]) return;
        mem[i][cw] = true;

        cal(i + 1, cw);
        if(cw + goodWeights[i] <= bagWeight) {
            cal(i + 1, cw + goodWeights[i]);
        }
    }

    /**
     * 动态规划实现
     */
    public static void knapsack() {
        boolean[][] state = new boolean[n][bagWeight + 1];
        state[0][0] = true;
        state[0][goodWeights[0]] = true;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < bagWeight; j++) {
                if(state[i - 1][j]) state[i][j] = state[i - 1][j];
            }

            for(int j = 0; j <= bagWeight - goodWeights[i]; j++) {
                if(state[i - 1][j]) state[i][j + goodWeights[i]] = true;
            }
        }

        for(int i = bagWeight; i >= 0; i--) {
            if(state[n - 1][i]) {
                maxWeight = i;
                break;
            }
        }
    }

    /**
     * 动态规划实现2
     */
    public static void knapsack2() {
        boolean[] states = new boolean[bagWeight + 1];
        states[0] = true;
        states[goodWeights[0]] = true;
        for(int i = 1; i < n; i++) {
            for(int j = bagWeight - goodWeights[i]; j >= 0; j--) {
                if(states[j]) states[j + goodWeights[i]] = true;
            }
        }

        for(int i = bagWeight; i >= 0; i--) {
            if(states[i]) {
                maxWeight = i;
                break;
            }
        }
    }

    public static void main(String[] args) {
//        cal(0, 0);
//        knapsack();
        knapsack2();
        System.out.println(maxWeight);
    }
}
