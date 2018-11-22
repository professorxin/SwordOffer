package Offer22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*题目描述
    从上往下打印出二叉树的每个节点，同层节点从左至右打印。*/

    //这道题目考察的是层次遍历

     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }
     }

    //牛客网高票答案
    //使用ArrayList来模拟队列
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<TreeNode> queue=new ArrayList<TreeNode>();
        if(root==null) return list;
        queue.add(root);
        while(queue.size()>0){
            //移出队列的首位结点
            TreeNode temp=queue.remove(0);
            //保存移出结点的值
            list.add(temp.val);
            //如果左儿子非空，加入队列中
            if(temp.left!=null) queue.add(temp.left);
            //如果右儿子非空，加入队列中
            if(temp.right!=null) queue.add(temp.right);
        }
        return list;
    }



    //这种做法和上面同理，只是直接构建了队列
    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }
}
