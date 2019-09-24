package algo;

public class T45JumpGame{
    public static int jump(int[] nums){
        int end = 0;
        int max_pos = 0;
        int steps = 0;
        for(int i = 0 ; i < nums.length - 1; i++){
            if(nums[i] != 0){
                max_pos = Math.max(max_pos, nums[i]+i);
            }else{

            }
            if(i < max_pos && nums[i] == 0){
                max_pos = max_pos;
            }
            if(i == end){
                end = max_pos;
                ++steps;
            }
        }
        return steps;
    }

    public static  int jump_1(int[] nums){
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int end = 0;
        int max_pos = 0;
        int steps = 0;
        if(n == 1) return 0;
        for(int i = 0 ; i <= max_pos; i++){
            max_pos = Math.max(max_pos , i + nums[i]);
            if(i == end){
                end = max_pos;
                steps++;
            }
            if(end >= n - 1){
                return steps;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {0};
        System.out.println(jump_1(nums));
    }
}