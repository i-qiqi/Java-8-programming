package swordoffer;

public class InversePairs {

    static long cnt = 0; //注意数据范围
    static int[] temp_arr;
    public static void main(String[] args){
//        int[] nums = {7,5,6,4};
        int[] nums = {3,1,2,1,4};
        temp_arr = new int[nums.length];
        mergeSort(nums , 0 , nums.length-1);
        for(int x : nums){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println(cnt %1000000007);
    }

    public static void mergeSort(int[] nums , int low , int high){
        if(low >= high) return ;
        int mid = low + (high - low)/2;
        mergeSort(nums , low , mid);
        mergeSort(nums , mid+1 , high);
        merge(nums , low , mid , high);
    }

    public static void merge(int[] nums , int low , int mid , int high){
        int k = low , i = low , j = mid + 1;

        while(i <= mid || j <= high){
            if(i > mid){
                temp_arr[k++] = nums[j++];
            }else if(j > high){
                temp_arr[k++] = nums[i++];
            }else if(nums[i] <= nums[j]){
                temp_arr[k++] = nums[i++];
            }else{//逆序
                temp_arr[k++] = nums[j++];
                cnt += mid - i + 1;  // nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j]
            }
        }

        k = low;
        while(k <= high) nums[k] = temp_arr[k++];
    }
}
