package algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T62UniquePaths{
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for(int i = 2; i <= m ; ++i){
            for(int j = 1; j <= n; ++j){
                dp[j] = (j == 1) ? dp[j] : dp[j]+dp[j-1];
            }
        }
        return dp[n];
    }

    public int uniquePathWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for(int i = 1; i < n; i++) {
            if(obstacleGrid[0][i] == 1) dp[i] = 0;
            else dp[i] = dp[i-1];
        }
        for(int i = 1; i < m ; ++i){
            for(int j = 0; j < n; ++j){
                if(obstacleGrid[i][j] == 1) dp[j] = 0;
                else dp[j] = (j == 0) ? dp[j] : dp[j]+dp[j-1];
            }
        }
        return dp[n-1];
    }
    /**
     * T64 最小路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1; i < n; i++){
            dp[i] = dp[i-1]+grid[0][i];
        }

        for(int i = 1; i < m; ++i){
            for(int j = 0; j < n; ++j){
                dp[j] = ((j == 0) ? dp[j]  : Math.min(dp[j-1], dp[j])) + grid[i][j];
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args){
        T62UniquePaths t62UniquePaths = new T62UniquePaths();
        int[][] obstacleGrid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        t62UniquePaths.uniquePathWithObstacles(obstacleGrid);
    }
}