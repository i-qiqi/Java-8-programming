package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class T60KthPermutation {
    List<String> output = new LinkedList<>();
    private void permutation(int nums[], String ans, int n, boolean[] used){
        if(ans.length() == n){
            output.add(ans);
        }

        for(int i = 0; i < n; i++){
            if(used[i]) continue;
            used[i] = true;
            permutation(nums, ans + String.valueOf(nums[i]), n, used);
            // permutation(nums, ans + nums[i]+"", n, used);
            used[i] = false;
        }
    }
    public void printAllPermutation(int n){
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for(int i = 0; i < n; i++){
            nums[i] = i + 1;
            used[i] = false;
        }
        permutation(nums, "", n, used);
        System.out.println(output);
    }
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for(int i = 0; i < n; ++i){
            nums[i] = i + 1;
            used[i] = false;
        }
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        return dfs(nums, used, n , k, "", factorial);
        
    }
    private String dfs(int[] nums, boolean[] used, int n, int k,
                       String ans, int[] factorial){
        if(ans.length() == n){
            return ans;
        }
        
        int ps = factorial[n-1-ans.length()];
        for(int i = 0; i < n; ++i){
            if(used[i]) continue;
            if(ps < k){//剪枝
                k -= ps;
                continue;
            }
            used[i] = true;
            return dfs(nums, used, n, k, ans + String.valueOf(nums[i]),factorial);
        }
        
        throw new RuntimeException("参数错误");
    }

    public static void main(String[] args){
        T60KthPermutation t60KthPermutation = new T60KthPermutation();
        // String s = t60KthPermutation.getPermutation(3, 3);
        // System.out.println(s);
        t60KthPermutation.printAllPermutation(3);
    }
}
