package hash;

import java.util.ArrayList;
import java.util.List;

public class T5LongestPalindromeString {
    public static class Result{
        int length;
        int left;
        int right;
        Result(int le , int l, int r){
            length = le;
            left = l;
            right = r;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "length=" + length +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(s.substring(4 ,5));
        List<Result> results = longestPalindrome(s);
        for(Result r : results){
            System.out.println(r.toString());
            System.out.println(s.substring(r.left, r.right+1));
        }
    }

    /**
     * DP
     * dp[i][j] == dp[j][i]， 对三角矩阵
     * 状态转移方程
     * 1> dp[i][j] = dp[i+1][j-1], s[i] == s[j]
     * 2> dp[i][j] = 0 , s[i] != s[j]
     * O(n^2)
     * @param s
     * @return
     */
    public static  List<Result> longestPalindrome(String s) {
        int len = s.length();
        char[] s_arr = s.toCharArray();
        int[][] dp = new int[len][len];
        int max_len = 0;
        List<Result> res_list = new ArrayList<>();
        //边界
        //长度为1
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
            Result res_obj = new Result(1 , i , i);
            res_list.add(res_obj);
        }

        //长度为2
        for(int i = 0; i < len; i++){
            if(i+1 < len){
                dp[i][i+1] = (s_arr[i] == s_arr[i+1]) ? 1 : 0;
                if(max_len < 2 && dp[i][i+1] == 1){
                    res_list = new ArrayList<>();
                    max_len = 2;
                }

                if(max_len == 2 && dp[i][i+1] == 1){
                    Result res_obj = new Result(2 , i , i+1);
                    res_list.add(res_obj);
                }
            }
        }


        for(int k = 3; k < len;k++){
            for(int i = 0; i + k - 1 < len; i++){
                int j = i + k -1;
                if(s_arr[i] == s_arr[j]){
                    dp[i][j] = dp[i+1][j-1];
                    //存在长度为k的回文子串
                    if(max_len < k && dp[i][j] == 1){
                        res_list = new ArrayList<>();
                        max_len = k;
                    }
                    if(max_len == k && dp[i][j] == 1){
                        Result res_obj = new Result(k , i , j);
                        res_list.add(res_obj);
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return res_list;
    }


    /**
     * Manacher
     */
}
