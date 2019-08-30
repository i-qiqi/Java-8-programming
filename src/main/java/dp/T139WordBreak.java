package dp;

import java.util.List;

public class T139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 0 ; i < n ; i++){
            for(String word : wordDict){
                int len = word.length();
                if(len < i && word.equals(s.substring(i-len , i))){
                    dp[i] = dp[i] || dp[i-len];
                }
            }
        }

        return dp[n-1];
    }
}
