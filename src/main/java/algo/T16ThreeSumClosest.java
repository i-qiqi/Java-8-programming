package algo;

import java.util.Arrays;

public class T16ThreeSumClosest {
    public int threeSumCloset(int[] nums, int target){
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0 ; i < nums.length; ++i){
            int L = i + 1, R = nums.length - 1;
            while(L < R){
                int sum = nums[L] + nums[R] +nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }else if(sum > target){
                    R--;
                }else{
                    L++;
                }
            }
        }
        return ans;
    }
}