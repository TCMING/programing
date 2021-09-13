package exercise.dynamic_programming;

import java.util.Arrays;

public class MinimumPathSum64 {

    /**
     * 递归
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        if(grid == null || grid.length <= 0){
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        return minPathSum1(grid,row,column);
    }

    public int minPathSum1(int[][] grid,int row,int column) {
        if(row == 0 && column == 0){
            return grid[row][column];
        }
        int left = Integer.MAX_VALUE;
        if(row > 0){
            left = minPathSum1(grid,row-1,column);
        }
        int right = Integer.MAX_VALUE;
        if(column > 0){
            right = minPathSum1(grid,row,column-1);
        }
        return grid[row][column] + Math.min(left,right);
    }

    /**
     * 记忆化搜索
     * @param grid
     * @return
     */
    int[][] memo;
    public int minPathSum2(int[][] grid) {
        if(grid == null || grid.length <= 0){
            return 0;
        }
        memo = new int[grid.length][grid[0].length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        int row = grid.length - 1;
        int column = grid[0].length -1 ;
        return minPathSum2(grid,row,column);
    }

    public int minPathSum2(int[][] grid,int row,int column) {
        if(row == 0 && column == 0){
            return grid[row][column];
        }
        int left = Integer.MAX_VALUE;
        if(row > 0 ){
            if(memo[row-1][column] == -1){
                memo[row-1][column] = minPathSum2(grid,row-1,column);
            }
            left = memo[row-1][column];
        }
        int right = Integer.MAX_VALUE;
        if(column > 0 ){
            if( memo[row][column-1] == -1){
                memo[row][column-1] = minPathSum2(grid,row,column-1);
            }
            right = memo[row][column-1];
        }
        return grid[row][column] + Math.min(left,right);
    }

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length <= 0){
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length ;
        int[][] dp = new int[row][column];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        dp[0][0] = grid[0][0];
        for(int i=1; i < column; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i=1; i < row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i=1; i < row; i++){
            for(int j=1; j < column; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[row-1][column-1];
    }


    public static void main(String[] args) {
        MinimumPathSum64 pathSum64 = new MinimumPathSum64();
        int[][] grid = {{1,2,3},{4,5,6}};
        int res = pathSum64.minPathSum(grid);
        System.out.println(res);
    }

}
