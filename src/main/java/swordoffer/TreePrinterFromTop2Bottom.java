package swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class TreePrinterFromTop2Bottom {
    public  static class TreeNode{
        int val = 0;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){
        TreeNode[] nodes = new TreeNode[6];
        for(int i = 0; i < nodes.length ; i++){
            nodes[i] = new TreeNode(i+1);
        }
        TreeNode root = nodes[0];
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];
        nodes[2].left = nodes[5];

        System.out.println(PrintZigZag(root));
    }

    /**
     * 打印二叉树
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode front = queue.poll();
            ans.add(front.val);
            if(front.left != null){
                queue.offer(front.left);
            }
            if(front.right != null){
                queue.offer(front.right);
            }
        }

        return ans;
    }

    /**
     * 打印成多行
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> lineAns = new ArrayList<>();
        if(root == null) return ans;
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            TreeNode front = queue.poll();
            if(front == null){
                ans.add(lineAns);
                lineAns = new ArrayList<>();
                if(!queue.isEmpty()) queue.offer(null);
            }else{
                lineAns.add(front.val);
                if(front.left != null){
                    queue.offer(front.left);
                }
                if(front.right != null){
                    queue.offer(front.right);
                }
            }
        }

        return ans;
    }

    public static ArrayList<ArrayList<Integer> > PrintZigZag(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> lineAns = new ArrayList<>();
        if(root == null) return ans;
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            TreeNode front = queue.poll();
            if(front == null){
                if((ans.size() & 1) == 1){
                    Collections.reverse(lineAns);
                }
                ans.add(lineAns);
                lineAns = new ArrayList<>();
                if(!queue.isEmpty()) queue.offer(null);
            }else{
                lineAns.add(front.val);
                if(front.left != null){
                    queue.offer(front.left);
                }
                if(front.right != null){
                    queue.offer(front.right);
                }
            }
        }

        return ans;
    }


}
