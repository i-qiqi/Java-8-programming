package bishi;

import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
      int[] input = {2 ,2,3,0 ,3,4};
      report(input, 6, 0);
    }

    public static void  report(int n , int i){
        if(n == 0) return ;
        if(n == 1) return ;
        System.out.println(nums[i % n]);
        report(nums , n, i + 3);
    }
}