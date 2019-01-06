package Offer62;

import java.util.ArrayList;

public class Solution {
    /*题目描述
    给定一棵二叉搜索树，请找出其中的第k小的结点。例如,（5，3，7，2，4，6，8）中，
    按结点数值大小顺序第三小结点的值为4。*/

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    //第k小的结点就是二叉搜索树中序排列的第k个元素
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        ArrayList<TreeNode> list=new ArrayList<>();
        middleOrder(list,pRoot);
        if(k==0 || list.size()<k) return null;
        return list.get(k-1);
    }

    //中序排列
    public void middleOrder(ArrayList<TreeNode> list,TreeNode pRoot){
        if(pRoot==null) return;
        middleOrder(list,pRoot.left);
        list.add(pRoot);
        middleOrder(list,pRoot.right);
    }
}
