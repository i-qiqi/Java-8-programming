package binarysearch;

public class T33RoutarySortedArray {
    public static void main(String args[]){
        int[] nums = {7,9,12,15,1,3,6};
        int target = 3;
        System.out.println(search(nums , target));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        int mid = (left + right)/2;
        while(left < right){
            if(target > nums[mid]){
                 left = mid + 1;
            }else if(target < nums[mid]){
                 if(target > nums[left]){
                     right = mid - 1;
                 }else{
                     left = mid + 1;
                 }
            }else{
                return mid;
            }
        }
        return -1;
    }
}
