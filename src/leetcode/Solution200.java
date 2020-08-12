package leetcode;

/**
 * 岛屿数量(https://leetcode-cn.com/problems/number-of-islands/)
 * Created by xsg on 2020/8/12.
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res ++;
                    helper(grid, i, j, row, col);
                }
            }
        }
        return res;
    }

    private void helper(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        helper(grid, i + 1, j, row, col);
        helper(grid, i - 1, j, row, col);
        helper(grid, i, j + 1, row, col);
        helper(grid, i, j - 1, row, col);
    }

}
