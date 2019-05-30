package algorithm;

/**
 * 将一组不同重量、不同价值的物品装入背包，求在满足背包最大重量限制的前提下，背包中物品总价值的最大值
 * Created by xsg on 2019/5/29.
 */
public class AddToBag2 {
    //存放最大价值
    private static int maxValue = Integer.MIN_VALUE;
    //物品重量
    private static int[] goodWeights = {2, 2, 4, 6, 3};
    //物品价值
    private static int[] goodValue = {3, 4, 8, 9, 6};
    //物品数量
    private static int n = goodWeights.length;
    //背包的最大重量
    private static int bagWeight = 9;

    /**
     * 动态规划查找
     */
    public static void knapsack() {
        int[][] states = new int[n][bagWeight + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= bagWeight; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if(goodWeights[0] <= bagWeight) {
            states[0][goodWeights[0]] = goodValue[0];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= bagWeight; j++) {
                if(states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            for(int j = 0; j <= bagWeight - goodWeights[i]; j++) {
                if(states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + goodValue[i];
                    if(v > states[i][j + goodWeights[i]]) {
                        states[i][j + goodWeights[i]] = v;
                    }
                }
            }
        }

        for(int i = 0; i <= bagWeight; i++) {
            if(states[n - 1][i] > maxValue) {
                maxValue = states[n - 1][i];
            }
        }

    }


    public static void main(String[] args) {
        knapsack();
        System.out.println(maxValue);
    }
}
