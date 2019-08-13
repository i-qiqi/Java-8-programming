package swordoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeastKnum {

    public static  void main(String args[]){
        int[] nums = {4,5,1,6,2,2,3,7,3,8};
//        System.out.println(partition_1(nums,0,nums.length-1));
        quickSort(nums, 0 , nums.length-1);
        for(int x : nums) {
            System.out.println(x);
        }
//        System.out.println(getKthLeastNumbers(nums , 4));
    }

    static void quickSort(int[] nums , int left , int right){
        if(left > right) return;
        int p = partition_1(nums , left , right);
        quickSort(nums, left , p-1);
        quickSort(nums, p+1 , right);
    }

    static List<Integer> getKthLeastNumbers(int nums[] , int k){
        List<Integer> ans = new ArrayList<>();
        if(nums.length < k || k <= 0) return ans;
        findKthSmallest(nums , k - 1);
        for(int i = 0; i < k; i++){
            ans.add(nums[i]);
        }

        return ans;
    }

    static void findKthSmallest(int nums[] , int k){
        int l = 0 , h = nums.length - 1;
        while(l < h){
            int j = partition_1(nums , l , h);
            if(j == k){
                break;
            }else if(j < k){
                l = j + 1;
            }else{
                h = j - 1;
            }
        }
    }


    static int partition_1(int[] nums, int low , int high){
        int p = nums[high];
        int left = low;
        int right = high;
        while(left < right){
            while(left < right && nums[left] < p) left++;
            while(left < right && nums[right] >= p) right--;
            if(left < right) swap(nums , left , right);
        }
        swap(nums , left , high);
        return left;

    }

    int partition_standard(int[] arr , int low , int high){
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }
    /**
     * 单向扫描法
     * @param nums
     * @param low
     * @param high
     * @return
     */
    static int partition(int[] nums, int low , int high){
      int pivot = nums[high];
      int k = low;
      for(int i = low ; i < high ; i++){
            if(nums[i] < pivot){
                swap(nums , i , k);
                k++;
            }
        }
      swap(nums , k , high);
      return k;
    }


    static void swap(int[] nums , int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(k > nums.length || k <= 0) return ans;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1 , o2)-> o2 - o1);
        for(int x : nums){
            maxheap.add(x);
            if(maxheap.size() > k){
                maxheap.poll();
            }
        }

        ans.addAll(maxheap);
        return ans;
    }
}
