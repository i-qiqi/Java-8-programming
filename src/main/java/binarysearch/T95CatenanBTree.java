package binarysearch;

import java.util.LinkedList;
import java.util.List;

public class T95CatenanBTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n){
        if(n == 0){
            return new LinkedList<TreeNode>();
        }else{
            return process(1, n);
        }
    }

    private List<TreeNode> process(int begin, int end){
        List<TreeNode> all_trees = new LinkedList<>();
        if(begin > end){
            all_trees.add(null);
            return all_trees;
        }

        for(int i = begin ; i <= end ; ++i){
            List<TreeNode> left_trees = process(begin , i-1);
            List<TreeNode> right_trees = process(i+1, end);
            for(TreeNode l : left_trees){
                for(TreeNode r: right_trees){
                    TreeNode temp_root = new TreeNode(i);
                    temp_root.val = i;
                    temp_root.left = l;
                    temp_root.right = r;
                    all_trees.add(temp_root);
                }
            }
        }

        return all_trees;
    }
}
