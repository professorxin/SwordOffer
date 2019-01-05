package Offer59;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    //相邻两层的节点方向都不同，每一层都需要一个栈去保存，所以需要两个栈
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.add(pRoot);
        //current变量用于表示层数，为1时表示奇数层，stack2要先添加左孩子，再添加右孩子。为0时表示偶数层，stack1要先添加右孩子，再添加左孩子。
        int current=1;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int size1=stack1.size();
            int size2=stack2.size();
            if(current==1){
                while(size1-->0){
                    TreeNode node=stack1.pop();
                    if(node==null) continue;
                    list.add(node.val);
                    stack2.add(node.left);
                    stack2.add(node.right);
                }
            }else{
                while(size2-->0){
                    TreeNode node=stack2.pop();
                    if(node==null) continue;
                    list.add(node.val);
                    stack1.add(node.right);
                    stack1.add(node.left);
                }
            }
            current=1-current;
            if(list.size()!=0){
                result.add(list);
            }
        }
        return result;
    }
}
