package Offer17;

public class Solution {
    /*题目描述
    输入两棵二叉树A，B，判断B是不是A的子结构。
    （ps：我们约定空树不是任意一个树的子结构）*/

     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }
     }


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        //两棵树非空才进行比较，否则返回false;
        if(root1!=null&&root2!=null){
            //找到tree1中与tree2的根结点相同的结点
            if(root1.val==root2.val){
                //以该结点进行判断是否包含tree2
                result=doesTree1HaveTree2(root1,root2);
            }
            //没有找到结点或者不包含，继续以tree1的左儿子作为起点
            if(!result){
                result=HasSubtree(root1.left,root2);
            }
            //没有找到结点或者不包含，继续以tree1的右儿子作为起点
            if(!result){
                result=HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode node1,TreeNode node2){
         //node2结点遍历完成都能对应的上，返回正确
         if(node2==null) return true;
         //node1结点遍历完成，node2没有遍历完，返回错误
         if(node1==null) return false;
         //结点对应不上，返回错误
         if(node1.val!=node2.val) return false;
         //递归分别比较左儿子和右儿子，与条件
         return doesTree1HaveTree2(node1.left,node2.left)&&doesTree1HaveTree2(node1.right,node2.right);
    }
}
