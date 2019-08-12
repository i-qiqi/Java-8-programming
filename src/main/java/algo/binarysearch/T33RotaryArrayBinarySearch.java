package algo.binarysearch;

public class T33RotaryArrayBinarySearch{

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        int target = 1;
        System.out.println(search_1(nums, target));
    }

    /**
     * 更快
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums , int target){
        int begin = 0 , end = nums.length-1;
        int left = 0 , right = nums.length-1;
        if(nums.length == 1){
            return target == nums[0] ? 0 : -1;
        }
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(target < nums[mid]){
                if(nums[mid] >= nums[begin]){//nums[mid]在前半段
                     if(target >= nums[begin]){
                        right = mid - 1 ;
                     }else{
                        left = mid + 1;
                     }
                }else{//nums[mid]后半段
                    right = mid - 1;
                }
            }else if(target > nums[mid]){
                if(nums[mid] >= nums[begin]){//nums[mid]在前半段
                    left = mid + 1;
                }else{//nums[mid]后半段
                    if(target >= nums[begin]){
                        left = begin;
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 慢一些
     * @param nums
     * @param target
     * @return
     */
    public static int search_1(int[] nums , int target){
        int begin = 0 , end = nums.length-1;
        int left = 0 , right = nums.length-1;
        if(nums.length == 1){
            return target == nums[0] ? 0 : -1;
        }

        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(target == nums[mid]) return mid;
            if(nums[mid] >= nums[begin]){//左区间
                if(target > nums[mid]){
                    left = mid + 1;
                }else{
                    if(target >= nums[begin]){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                        right = end;
                    }
                }
            }else{//旋转区间
                if(target > nums[mid]){
                    if(target >= nums[begin]){
                        left = begin;
                        right = mid - 1;
                    }else{
                        left = mid  + 1;
                    }
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}