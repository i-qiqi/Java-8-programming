package bishi;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    // public static void main(String[] args){
    //     // Scanner sc = new Scanner(System.in);
    //     // int n = sc.nextInt();
        
    //     // int[][] nums = new int[n][2];
        
    //     // for(int i = 0; i < n; i++){
    //     //     nums[i][0] = sc.nextInt();
    //     //     nums[i][1] = sc.nextInt();
    //     // }
    //     // int n = 5;
    //     // int[][] nums = {
    //     //     {3,4},
    //     //     {1,5},
    //     //     {2,9},
    //     //     {4,18},
    //     //     {5, 201}
    //     // };
    //     int cnt = 1;
    //     int x = 1;
    //     for(int i = 1; i < 10000; i++){
    //         if(IsPalindrome(i)){
    //             if(i >= x){
    //                 System.out.println("--------");
    //                 x *= 10;
    //             } 
    //             System.out.println((cnt)+" : "+i + " " +calKthPalin(cnt));
    //             cnt++;
    //         } 
    //     }
        
    // }

    // public static boolean   IsPalindrome(int x) {
    //     if(x == 0) return true;
    //     if(x < 0 || (x % 10 == 0 && x != 0)) {
    //         return false;
    //     }

    //     int revertedNumber = 0;
    //     while(x > revertedNumber) {
    //         revertedNumber = revertedNumber * 10 + x % 10;
    //         x /= 10;
    //     }
    //     return x == revertedNumber || x == revertedNumber/10;
    // }

    // public static int calKthPalin(int k){
    //     int d = 9;
    //     int degree = 0;
    //     for(degree = 1; ; degree++){
    //         if(k - d <= 0) break;
    //         k -= d;
    //         if((degree & 1) == 0) d *= 10;
    //     }

    //     return calKthOfDegree(degree, k);
    // }

    // public static int calKthOfDegree(int n , int k){
    //    int half_len = (n+1)/2; //不管奇数还是偶数

    //    int half_num = 1;
    //    for(int i = 2; i <= half_len; i++){
    //        half_num *= 10;
    //    }
    //    half_num += k-1;
    // //    int left_num = k - 1 + (int)Math.pow(10, (n+1)/2 - 1);
    // //    StringBuilder s = new StringBuilder(String.valueOf(left_num));
    // //    StringBuilder ans = (k & 1) == 1 ? s.append(s.reverse().deleteCharAt(0)) : s.append(s.reverse());
    // //    return ans.toString();
    //     int ans = half_num;
    //     if((n & 1) == 1){
    //         half_num /= 10;
    //     }
    //     while(half_num != 0){
    //         ans = ans * 10 + half_num % 10;
    //         half_num /= 10;
    //     }

    //     return ans;
    // }
}