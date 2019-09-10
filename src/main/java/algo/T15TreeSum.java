package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class T15TreeSum{
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); //排序
        for(int i = 0; i < len; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue; //去重
            int L = i+1;
            int R = len -1 ;
            while(L < R){ //双指针
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i] , nums[L] , nums[R]));
                    while(L < R && nums[L] == nums[L+1]) L++; //去重
                    while(L < R && nums[R] == nums[R-1]) R--; //去重
                    L++;
                    R--;
                }else if(sum < 0){
                    L++;
                }else{
                    R--; 
                }
            }
        }
        return ans;
        
    }
}