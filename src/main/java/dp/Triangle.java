package dp;

import java.util.List;

public class Triangle {
    public static void main(String[] args) {

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        for(int i = 0 ; i < triangle.get(len-1).size(); i++){
            dp[len-1][i] = triangle.get(len-1).get(i);
        }
        for(int i = len - 1 ; i >= 0 ; i--){
            List<Integer> arr = triangle.get(i);
            for(int j = 0 ; j < arr.size() ; j++){
                if(i + 1 < len){//如果有下一行
                    dp[i][j] = Math.min(dp[i+1][j] , dp[i+1][j+1]) + arr.get(j);
                }
            }
        }
        return dp[0][0];
    }


    /**
     * 使用滚动数组，O(n)空间复杂度
     * @param triangle
     * @return
     */
    public static int minimumTotal_1(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        for(int i = 0 ; i < triangle.get(len-1).size(); i++){
            dp[i] = triangle.get(len-1).get(i);
        }
        for(int i = len - 1 ; i >= 0 ; i--){
            List<Integer> arr = triangle.get(i);
            for(int j = 0 ; j < arr.size() ; j++){
                if(i + 1 < len){//如果有下一行
                    dp[j] = Math.min(dp[j] , dp[j+1]) + arr.get(j);
                }
            }
        }
        return dp[0];
    }
}
