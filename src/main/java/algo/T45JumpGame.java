package algo;

public class T45JumpGame{
    public static  int jump(int[] nums){
        int end = 0;
        int max_pos = 0;
        int steps = 0;
        for(int i = 0 ; i < nums.length - 1; i++){
            max_pos = Math.max(max_pos, nums[i]+i);
            if(i == end){
                end = max_pos;
                ++steps;
            }
        }
        return steps;
    }

    public static void main(String[] args){
        int[] input = {2 ,2,3,0,4};
        System.out.println(jump(input));
      }
  
}