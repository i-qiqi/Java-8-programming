package algo;

public class T300LIS{
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for(int num : nums){
            int i = 0 , j = len;
            while(i < j){
                int m = i + (j - i)/2;
                if(tails[i] < num){
                    m = i + 1;
                }else{
                    j = m;
                }
            }
            
        }
    }
}