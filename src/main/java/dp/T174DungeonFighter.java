package dp;

import java.util.Arrays;

public class T174DungeonFighter{
    public int calculateMinmumHP(int[][] dungeon){
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] memory = new int[m][n];
        for(int[] arr : memory) Arrays.fill(arr, -1);

        return dfs(0 , 0, m , n, dungeon , memory) + 1;
    }

    /**
     * 递归　＋　记忆化搜索
     * f(i,j) +dungeon(i,j) = min(f(i+1, j) , f(i,j+1)) 
     */
    public int dfs(int i , int j , int m , int n, int[][] dungeon ,int[][] memory){
        if(i >= m || j >= n) return Integer.MAX_VALUE;
        if(memory[i][j] != -1) return memory[i][j];
        if(i == m - 1 && j == n - 1){
            return dungeon[i][j] >= 0 ? 0 : -dungeon[i][j];
        }

        int min_down = dfs(i+1, j , m , n , dungeon, memory);
        int min_right = dfs(i, j + 1, m , n, dungeon, memory);
        int min_need = Math.min(min_down , min_right) - dungeon[i][j];
        int ans = min_need < 0 ? 0 : min_need;
        memory[i][j] = ans;
        // System.out.println(i+ " "+j + " "  + ans);
        return ans;
    }

    public int calculateMinmumHP_dp(int[][] dungeon){
          if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] dp = new int[n];
        //初始化最后一行
        dp[n-1] = dungeon[m-1][n-1] >= 0 ? 0 : -dungeon[m-1][n-1];
        for(int j = n - 2 ; j >= 0 ; j--){
            int min_need = dp[j+1] - dungeon[m-1][j];
            dp[j] = min_need <= 0 ? 0 : min_need;
        }
        //依次滚动计算其他行
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int min_need = 0;
                if(j == n - 1){
                    min_need = dp[j] - dungeon[i][j];
                }else{
                    min_need =  Math.min(dp[j+1], dp[j]) - dungeon[i][j];
                }

                dp[j] = min_need <= 0 ? 0 : min_need;
            }
        }  
        return dp[0] + 1;   
    }


    public static void main(String[] args){
        int[][] dungeon = {
            {-2, -3, 3},
            {-5 , -10, 1},
            {10 ,30, -5}
        };
        T174DungeonFighter t174DungeonFighter = new T174DungeonFighter();

        t174DungeonFighter.calculateMinmumHP(dungeon);
    }
}