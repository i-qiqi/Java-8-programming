package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T18fourSum {
  
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; ++i) {
            //固定nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break; //最小值
            if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;//当前最大值，只有增加nums[i]
            for (int j = i + 1; j < n - 2; ++j) {
                //再固定nums[j]
                if (j - i > 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;
                int L = j + 1;
                int R = n - 1;
                while (L < R) { //双指针
                    int tmp = nums[i] + nums[j] + nums[L] + nums[R];
                    if (tmp == target) {
                        List<Integer> tmpList = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        ans.add(tmpList);
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    } else if (tmp > target) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
        return ans;
    }
}