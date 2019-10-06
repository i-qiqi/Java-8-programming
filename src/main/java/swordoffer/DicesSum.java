package swordoffer;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class DicesSum{
    public List<Map.Entry<Integer, Double>> dicesSumProb(int n){
        int[][] dp = new int[n+1][6*n+1];
        List<Map.Entry<Integer, Double>> output = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n ; i++){
            for(int j = i; j <= 6*i; j++){
                for(int k = 1 ; k <= 6 ; k++){
                    if(j - k >= i - 1 && j - k <= 6*(i-1)){
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }

        // for(int[] cnt : dp){
        //     for(int num : cnt){
        //         if(num != 0) System.out.print(num+" ");
        //     }
        //     System.out.println();
        // }
        // for(int num : dp[n]){
        //     if(num != 0) System.out.print(num+" ");
        // }
        // System.out.println();
    
        final double totalnum = Math.pow(6 , n);
        for(int num : dp[n]){
            if(num != 0) {
                output.add(new AbstractMap.SimpleEntry<Integer, Double>(num , num/totalnum));
            }
        }
       
        return output;
    }

    public static void main(String[] args){
        DicesSum ds = new DicesSum();
        List<Map.Entry<Integer, Double>> ans = ds.dicesSumProb(6);
        for(Map.Entry<Integer, Double> e : ans){
            System.out.println(e.getKey()+" : "+e.getValue());
        }
    }
}