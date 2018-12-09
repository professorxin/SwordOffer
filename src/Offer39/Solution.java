package Offer39;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /*题目描述
    输入一棵二叉树，判断该二叉树是否是平衡二叉树。*/
    public boolean IsBalanced_Solution(TreeNode root) {
        return height(root) == -1 ? false : true;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        //如果已经判断出不是平衡二叉树了，直接返回-1
        if (left == -1) return -1;
        int right = height(root.right);
        //如果已经判断出不是平衡二叉树了，直接返回-1
        if (right == -1) return -1;
        //左右子树高度差大于1，返回-1
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        //左右子树高度差不大于1，返回子树最大值+1
        return Math.max(left, right) + 1;
    }


}
