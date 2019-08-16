package swordoffer;

public class BSTtoDelinklist {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    TreeNode pre = null;//前驱
    TreeNode head; //头节点
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);//执行此句后，head指向链表头部，pre指向尾部
        root.left = pre;
        if(pre != null) pre.right = root;
        pre = root;
        if(head == null) head = root;
        inOrder(root.right);
    }

    public  TreeNode convert(TreeNode root){
        inOrder(root);
        return head;
    }

//    链接：https://www.nowcoder.com/questionTerminal/d567727f21a247f7b64ba32431cb9a19?f=discussion

    /*
    写一个回答，确实只是个二叉树编码问题
    */
    public static class Tree {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        StringBuilder maxPath;
        StringBuilder minPath;
        void preOrder(TreeNode t,char code,StringBuilder path){//先序遍历、记录最大和最小权值叶子节点从根出发的路径，往左走记0，往右走记1
            if(t!=null){
                path.append(code);
                if(t.left==null&&t.right==null){
                    if(max<t.val){
                        max=t.val;
                        maxPath=path;
                    }
                    if(min>t.val){
                        min=t.val;
                        minPath=path;
                    }
                }
                preOrder(t.left, '0', new StringBuilder(path));
                preOrder(t.right, '1', new StringBuilder(path));
            }

        }
        public int getDis(TreeNode root) {
            // write code here
            preOrder(root, '0', new StringBuilder());
            int cl=0;
            for(;cl<(maxPath.length()>minPath.length()?maxPath.length():minPath.length());cl++)//统计相同路径的长度
                if(maxPath.charAt(cl)!=minPath.charAt(cl))
                    break;
            return (maxPath.length()+minPath.length()-2*cl);//最终返回值为两个路径长度减相同路径长度的两倍
        }
    }

}
