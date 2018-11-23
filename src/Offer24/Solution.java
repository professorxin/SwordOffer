package Offer24;

import java.util.ArrayList;

public class Solution {
    /*题目描述
    输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    (注意: 在返回值的list中，数组长度大的数组靠前)*/

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    //采用了回溯的思想，这是一种深度优先的方式

    //全局变量
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        //如果结点为空，直接返回
        if (node == null)
            return;
        //添加结点
        path.add(node.val);
        //目标值减去结点值
        target -= node.val;
        //如果目标值减为0而且左子树和右子树为空就表示该路径为所需路径,加入全局变量的集合中
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<Integer>(path));
        } else {
            //递归调用左儿子
            backtracking(node.left, target, path);
            //递归调用右儿子
            backtracking(node.right, target, path);
        }
        //删除最后一位元素，让其返回上一个结点（即父节点）
        path.remove(path.size() - 1);
    }
}
