package graphsearch;

public class T695MaxAreaOfIsland{

    int m , n;
    int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        int ans = 0;

        boolean[][] global = new boolean[m][n];
        int[] cnt = new int[1];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(!global[i][j] && grid[i][j] == 1){
                    cnt[0] = 0;
                    dfs(grid , i , j, cnt, global);
                    ans = Math.max(cnt[0] , ans);
                    System.out.println("area = "+ ans);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid ,int i , int j , int[] cnt ,  boolean[][] global){
        if(i < 0 || i >= m || j < 0
                || j >= n || global[i][j] || grid[i][j] == 0) return;
        global[i][j] = true;
        cnt[0]++;
        for(int[] d : directions){
            int next_i = i + d[0];
            int next_j = j + d[1];
            dfs(grid , next_i , next_j, cnt,  global);
        }
    }
   public static void main(String[] args){
       int[][] matrix = {
               {0,0,1,0,0,0,0,1,0,0,0,0,0},
               {0,0,0,0,0,0,0,1,1,1,0,0,0},
               {0,1,1,0,1,0,0,0,0,0,0,0,0},
               {0,1,0,0,1,1,0,0,1,0,1,0,0},
               {0,1,0,0,1,1,0,0,1,1,1,0,0},
               {0,0,0,0,0,0,0,0,0,0,1,0,0},
               {0,0,0,0,0,0,0,1,1,1,0,0,0},
               {0,0,0,0,0,0,0,1,1,0,0,0,0}
       };

       T695MaxAreaOfIsland t695MaxAreaOfIsland = new T695MaxAreaOfIsland();
       int res = t695MaxAreaOfIsland.maxAreaOfIsland(matrix);
       System.out.println(res);
   }
}