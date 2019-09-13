package classic;

import java.util.HashMap;
import java.util.Map;

public class T560SubArraySum{
    /**
     * O(n^2)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int ans = 0;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for(int i = 1; i < n; ++i){
            sums[i] = sums[i-1] + nums[i];
        }
        for(int i = 0; i < n ; ++i){
            for(int j = i; j < n; ++j){
                if(sums[j] - sums[i] + nums[i] == k){
                    ans++;
                }
            }
        }
        return ans;
    }
    public int subarraySum_1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n ; ++i){
            int s = 0;
            for(int j = i; j < n; ++j){
                s += nums[j];
                if(s == k){
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * O(N)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_hash(int[] nums, int k){
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] sums = new int[n+1];
        int ans = 0;
        for(int i = 1; i <= n; ++i){
            sums[i] = sums[i-1] + nums[i-1];
            if(sums[i] == k) ans++;
            ans += cnt.getOrDefault(sums[i] - k, 0);           
            cnt.put(sums[i], cnt.getOrDefault(sums[i], 0) + 1);

        }

        return ans;
    }
}