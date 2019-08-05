package dp;

public class CoinChange {
    public static void main(String[] args){

    }
    public static  int findCoinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        //初始化dp数组
        for(int i = 1 ; i <= amount ; i++){
            dp[i] = -1;
        }
        for(int i = 0 ; i < coins.length ; i++){
            if(coins[i] <= amount) dp[coins[i]] = 1;
        }

        //递推
        for(int i = 1 ; i <= amount ; i++){
            for(int j = 0 ; j < coins.length ; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != -1){
                    dp[i] = (dp[i] != -1) ? Math.min(dp[i - coins[j]] + 1 , dp[i]) : dp[i - coins[j]] + 1;
                }
            }
        }
        return dp[amount];
    }

    public int findCoinChange_1(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        //初始化dp数组
        for(int i = 0 ; i <= amount ; i++){
            dp[i] = -1;
        }

        dp[0] = 0;
        //递推
        for(int i = 1 ; i <= amount ; i++){
            for(int j = 0 ; j < coins.length ; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != -1){
                    if(dp[i] == -1 || dp[i] > (dp[i - coins[j]] + 1)){
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
