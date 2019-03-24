package Offer18;

public class Solution {
    /*题目描述
    操作给定的二叉树，将其变换为源二叉树的镜像。
    输入描述:
    二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5*/


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root) {
        //结点非空才进行交换
        if (root != null) {
            //左儿子和右儿子进行交换
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            //左儿子非空，递归左儿子
            if (root.left != null) Mirror(root.left);
            //右儿子非空，递归右儿子
            if (root.right != null) Mirror(root.right);
        }
    }


}
