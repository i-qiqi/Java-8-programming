package bishi;
import java.util.HashMap;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        HashMap<Integer , Integer> cnt = new HashMap<>();
        int[] dp = new int[n];
        for(int i = 0; i < n ; i++){
            nums[i] = sc.nextInt();
            cnt.put(nums[i] , cnt.getOrDefault(nums[i] , 0)+1);
        }
        
        int m = sc.nextInt();
        int k = 0;
        while(k < m){
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            
            for(int x = i ; x <= j ; x++){
                cnt.put(nums[x] , cnt.getOrDefault(nums[x] , 0)+1);
            }
            int ans = 0;
            for(int x = i ; x <= j ; x++){
                if(cnt.get(nums[x]) == 1){
                    ans++;
                }
            }
            System.out.println(ans);
            k++;
        }
        
    }
}