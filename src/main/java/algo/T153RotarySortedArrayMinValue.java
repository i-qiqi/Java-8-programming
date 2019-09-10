package algo.binarysearch;

public class T153RotarySortedArrayMinValue{
    public static void main(String[] args) {
        int[] nums = {1,2,3,-1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[low] <= nums[high]) return nums[low];
            if(nums[mid] >= nums[0]){ //左区间
                low = mid + 1;
            }else{//右区间
                high = mid;
            }
        }
        
        return Math.min(nums[low] ,  nums[high]);
    }
}