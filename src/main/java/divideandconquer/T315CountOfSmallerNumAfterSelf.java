package divideandconquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T315CountOfSmallerNumAfterSelf {
    public static void  main(String[] args){
        int[] nums = {5,2,6,1};
        System.out.println(countSmaller(nums).toString());
    }

    public static class BSTNode{
        int val;
        int size;//树的节点总数
        BSTNode left , right;
        BSTNode(int x){
            this.val = x;
        }
    }
    public  static int smallerNumAfterSelf(BSTNode root , int val){
        root.size++;
        if(val > root.val){
            if(root.right == null) root.right = new BSTNode(val);
            return root.size - 1 - root.right.size+smallerNumAfterSelf(root.right , val);
        }else if(val < root.val){
            if(root.left == null) root.left = new BSTNode(val);
            return smallerNumAfterSelf(root.left , val);
        }else{
            return root.left == null ? 0 : root.left.size;
        }
    }
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        BSTNode root;
        if(nums == null || nums.length == 0) return ans;
        root = new BSTNode(nums[nums.length-1]);
        for(int i = nums.length - 1 ; i >= 0; i--){
            ans.add(smallerNumAfterSelf(root,nums[i]));
        }
        Collections.reverse(ans);
        return  ans;
    }
}
