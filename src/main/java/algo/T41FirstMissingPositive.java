package algo;

public class T41FirstMissingPositive{
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; ++i){
            while(nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]){ //不在自己位置上，就交换归位
                swap(nums , nums[i]-1 , i);
            }
        }
        for(int i = 0; i < len; ++i){
            if(nums[i] == i+1){
                return i+1;
            }
        }
        return len+1;
    }

    private void swap(int[] nums, int i , int j){
        if(i == j){
            return;
        }

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}