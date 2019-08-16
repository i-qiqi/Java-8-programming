package swordoffer;

public class MostCountNumber {
    public static void main(String[] args){
        int[] nums = {1,2,3,2,4,2,5,2,2,2,3};
        System.out.println(MoreThanHalfNum_Solution(nums));
    }

    /**
     * 当元素重复的次数比较小的时候，对于流算法不能在小于线性空间的情况下查找频率最高的元素
     * @param nums
     * @return
     */
    public static int MoreThanHalfNum_Solution(int [] nums) {
        int majority = 0;
        int cnt = 0;
        for(int x : nums){
            if(cnt == 0){
                majority = x;
                cnt = 1;
            }else if(x == majority){
                cnt++;
            }else{
                cnt--;
            }
        }
        cnt = 0;
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }
}
