package algo.binarysearch;

public class T81SearchInRotatedSortedArrayII{

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3,0,1,1};
        int target = 3;
        System.out.println(isContains(nums, target));
    }

    /**
     * 有重复的数
     */
    public static boolean search(int[] nums, int target) {
        int begin = 0 , end = nums.length-1;
        int left = 0 , right = nums.length-1;
        if(nums.length == 1){
            return target == nums[0];
        }
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(target < nums[mid]){
                if(inFirstSection(nums, mid)){//nums[mid]在前半段
                     if(target >= nums[begin]){
                        right = mid - 1 ;
                     }else{
                        left = mid + 1;
                     }
                }else{//nums[mid]后半段
                    right = mid - 1;
                }
            }else if(target > nums[mid]){
                if(inFirstSection(nums, mid)){//nums[mid]在前半段
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
                return true;
            }
        }
        return false;
    }

    public static boolean inFirstSection(int[] nums , int mid){
        int low = 0;
        // while(nums[low] == nums[mid]) low++; 
        // return nums[mid] > nums[0] || (nums[mid] == nums[0] && mid < low);
        while(nums[low] == nums[mid]){
            if(low == mid) return true;
            low++;
        }
        return nums[mid] > nums[0];
    }

    public static boolean isContains(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target){
                return true;
            }

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                while(low != mid && nums[low] == nums[mid]){
                    low++;
                }

                if(low == mid){
                    low = mid + 1;
                    continue;
                }
            }

            if(nums[low] != nums[mid]){
                if(nums[mid] > nums[low]){//左区间
                    if(target >= nums[low] && target < nums[mid]){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }else{//右区间
                    if(target <= nums[high] && target > nums[mid]){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }
            }else{
                if(nums[mid] < nums[high]){
                    if(target > nums[mid] && target <= nums[high]){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }else{
                    if(target >= nums[low] && target < nums[mid]){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }
            }

          

        }
        return false;
    }

    /**
     * 简洁
     * @param nums
     * @param target
     * @return
     */
    public boolean search_1(int[] nums, int target) {
        int low = 0,high = nums.length - 1;
        while(low <= high){
        	int mid =(low + high) / 2;
        	if(nums[mid] == target){
        		return true;
        	}
        	if(nums[mid] > nums[low]){
        		if(target < nums[mid] && target >= nums[low]){
        			high = mid - 1;
        		}else{
        			low = mid + 1;
        		}
        	}else if(nums[mid] < nums[low]){
        		if(target > nums[mid] && target < nums[low]){
        			low = mid + 1;
        		}else{
        			high = mid - 1;
        		}
        	}else{
        		low++;
        	}
        }
        return false;
    }
}