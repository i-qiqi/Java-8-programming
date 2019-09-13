package algo;

public class T72MinEditDistace{
    public int minDistance(String word1, String word2){
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // if one of the strings is empty
        if (n * m == 0) return n + m;

        for(int i = 1; i <= m ; ++i){ //word1 delete
            dp[i][0] = i;
        }

        for(int i = 1; i <= n ; ++i){//word1 insert
            dp[0][i] = i;
        }

        for(int i = 1 ; i <= m ; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1) ? dp[i-1][j-1] : 
                Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]) , dp[i][j-1])+1;
            }
        }

        return dp[m][n];
    }
}