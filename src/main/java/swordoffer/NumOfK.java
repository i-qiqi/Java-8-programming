package swordoffer;

public class NumOfK {
    public static void main(String args[]){
        int[] nums = {1 ,1, 1};
        int K = 1;
        int l = getLowerBoundOfK(nums, K);
        System.out.println(l);
        int h = getUpBoundOfK(nums, K);
        System.out.println(h);
        int cnt = l == -1 ? 0 : h - l + 1;
        System.out.println(cnt);

//        System.out.println("h = "+h+" l = "+l+" len = "+(h-l+1));

    }

    public static int getLowerBoundOfK(int [] array , int k) {
        int left = 0 , right = array.length - 1;
        int mid = 0;
        int ans = -1;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if(array[mid] == k){
                if(mid > 0 && array[mid - 1] == k){
                    right = mid - 1;
                }else{
                    ans = mid;
                    break;
                }
            }else if(array[mid] < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public static int getUpBoundOfK(int [] array , int k) {
        int left = 0 , right = array.length - 1;
        int mid = 0;
        int ans = -1;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if(array[mid] == k){
                if(mid < array.length - 1 && array[mid+1] == k){
                    left = mid + 1;
                }else{
                    ans = mid;
                    break;
                }
            }else if(array[mid] < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
