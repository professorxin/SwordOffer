package Offer38;

public class Solution {
    /*题目描述
    输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
    最长路径的长度为树的深度。*/

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public int TreeDepth(TreeNode root) {
        //如果结点为空，返回0
        if (root == null) return 0;
        //二叉树的长度等于左子树长度+1；
        int left = TreeDepth(root.left) + 1;
        //二叉树的长度等于右子树长度+1；
        int right = TreeDepth(root.right) + 1;
        //对比该节点的左子树高度和右子树高度，返回大的值
        return left > right ? left : right;
    }
}
