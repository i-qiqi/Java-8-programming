package algo;

public class T300LIS{
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for(int num : nums){
            int i = 0 , j = len;
            while(i < j){
                int m = i + (j - i)/2;
                if(tails[m] < num){
                    i = m + 1;
                }else{
                    j = m;
                }
            } 
            tails[i] = num;
            if(j == len) len++; //i == j
        }
        return len;
    }

    public static void main(String[] args){
        int[] nums = {4 , 10 , 3};
        System.out.println(lengthOfLIS(nums));
    }
}