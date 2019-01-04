package Offer60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*题目描述
    从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。*/

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue =new LinkedList<TreeNode>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> result=new ArrayList<>();
            int size=queue.size();
            while(size-- >0){
                TreeNode node=queue.poll();
                if(node==null){
                    continue;
                }
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(result.size()!=0){
                list.add(result);
            }
        }
        return list;
    }

}
