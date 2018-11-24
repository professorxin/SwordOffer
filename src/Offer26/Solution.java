package Offer26;

public class Solution {
    /*题目描述
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    要求不能创建任何新的结点，只能调整树中结点指针的指向。*/

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //定义一个先前指针，指向的是当前有序链表的最末尾元素
    private TreeNode pre = null;
    //定义一个头指针，便于返回
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    //仔细观察可以看到整个的本质是一个中序遍历，在递归调用左儿子和右儿子之间的代码的用于处理指针的指向
    //因为中序遍历二叉搜索树的结果就是有序的，所以主要是要处理指针的指向
    private void inOrder(TreeNode node) {
        //如果结点为空，直接返回
        if (node == null)
            return;
        //左儿子递归调用
        inOrder(node.left);
        //当前结点的左儿子指向有序链表的最末尾元素
        node.left = pre;
        //如果当前有序链表的最后一个元素非空，他的右儿子就指向该结点
        if (pre != null)
            pre.right = node;
        //让pre指向当前有序链表的最后一个结点
        pre = node;
        //这句话只会使用到一次，只是为了确立头指针，用于返回答案
        if (head == null)
            head = node;
        //右儿子递归调用
        inOrder(node.right);
    }
}
