package classic;

public class MinStep2Palindrome{
    public int minStepsToPalin(String src){
        if(src == null || src.length() == 0) return 0;

        char[] src_arr = src.toCharArray();
        // StringBuilder  dest = new StringBuilder(src);
        // dest.reverse();
        int n = src_arr.length;
        char[] dest_arr = new char[n];
        for(int i = 0; i < n ; i++){
            dest_arr[i] = src_arr[n-1-i];
        }

        int[][] dp = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; ++i){
            for(int j = 1; j <= n; ++j){
                dp[i][j] = (src_arr[i-1] == dest_arr[j-1]) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return n - dp[n][n];
    }

    public int minStepsToPalin_1(String src){      
        if(src == null || src.length() == 0) return 0;
        int n = src.length();
        int[][] dp = new int[n][n];
        for(int k = 1; k < n; k++){
            for(int i = 0; i + k < n ; i++){
                int j = i + k; //  len = k+1
                dp[i][j] = (src.charAt(i) == src.charAt(j)) ? dp[i+1][j-1] : Math.min(dp[i+1][j] , dp[i][j-1]) + 1;
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args){
        MinStep2Palindrome minStep2Palindrome = new MinStep2Palindrome();
        System.out.println(minStep2Palindrome.minStepsToPalin("abbc"));
        System.out.println(minStep2Palindrome.minStepsToPalin_1("abbc"));
    }
}