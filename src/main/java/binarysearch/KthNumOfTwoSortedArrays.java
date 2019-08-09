package binarysearch;

public class KthNumOfTwoSortedArrays {

    public static void main(String args[]){
        int[] nums1 = {1,3};
        int[] nums2 = {3,4};
//        int k = 3;
        //测试中位数
        int len = nums1.length + nums2.length;
        double median =  (len & 1) == 1 ? findKthNum(nums1,nums2, len/2 + 1) :
                (findKthNum(nums1, nums2, len/2) + findKthNum(nums1,nums2, len/2 + 1)) * 1.0/2;
        System.out.println("Median = "+median);
//        System.out.println(findKthNum(nums1,nums2,k));
    }



    public static int findKthNum(int[] nums1 , int nums2[] , int k){
        if(nums1 == null && nums2 == null) {
            throw new RuntimeException("arrays is null");
        }
        if(k < 1 || k > nums1.length + nums2.length){
            throw new RuntimeException("k is invalid, out of bounds");
        }
        //处理临界情况
        int m = nums1.length , n = nums2.length;
        if(k <= m && (nums2.length == 0 || nums1[k - 1] <= nums2[0])){
            return nums1[k-1];
        }
        if(k <= n && (nums1.length == 0 || nums2[k-1] <= nums1[0])){
            return nums2[k-1];
        }
        //一般情况
        int i = 0 , j = 0, left = 0, right = Math.min(k , m) - 1;
        int left_part_max = 0;
        int cut_right_1 = Integer.MAX_VALUE, cut_right_2 = Integer.MAX_VALUE;
        while(left <= right){
            i = (left + right)/2;
            j = k - (i + 1) - 1; // 在nums2中的分界下标
            if(j < -1){//j落入A中，说明A数组较长
                right = i - 1;
            }else if(j <= n - 1){// j落入B中
                cut_right_1 = (i + 1 == m) ? Integer.MAX_VALUE : nums1[i+1];
                cut_right_2 = (j + 1 == n) ? Integer.MAX_VALUE : nums2[j+1];
                if(nums1[i] < nums2[j]){
                    left_part_max = nums2[j];
                    if(left_part_max <= cut_right_1){
                        //left_part_max <= nums1[i+1] , nums2[j+1] => is kthsmaller
                        return left_part_max;
                    }else{
                        //left_part_max in nums1[j+1:t] => not kthsmaller
                        //在右区间找，[i, right]
                        left = i + 1;
                    }
                }else {
                    left_part_max = nums1[i];
                    if (left_part_max <= cut_right_2) {
                        //left_part_max <= nums1[i+1] , nums2[j+1] => is kthsmaller
                        return left_part_max;
                    }else{
                        //left_part_max in nums2[j+1:t]中 => not kthsmaller
                        //在左区间找，[i, m]
                        right = i - 1;
                    }
                }

            }else {
                left = i + 1;
            }
        }

        return -1;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }



}
