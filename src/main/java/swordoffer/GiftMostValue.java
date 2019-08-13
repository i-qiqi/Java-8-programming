package swordoffer;

public class GiftMostValue {
    public static void main(String args[]){

        int[][] nums = {
                {1  ,  10  , 3  ,  8},
                {12  ,  2  , 9  ,  6},
                {5  ,   7  , 4  ,  11},
                {3  ,   7  , 16  ,  5}};
        System.out.println(getMost(nums));

    }

    //    1    10   3    8
    //    12   2    9    6
    //    5    7    4    11
    //    3    7    16   5

    public static int getMost(int[][] values){
        if(values == null || values.length == 0) return 0;
        int m = values.length;
        int n = values[0].length;
        int[] dp = new int[n];
        for(int i = 0 ; i < m ; i++) {
            dp[0] += values[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + values[i][j];
            }
        }
        return dp[n-1];
    }

}
