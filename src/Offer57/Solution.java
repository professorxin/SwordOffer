package Offer57;


public class Solution {

    /*题目描述
    给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，
    同时包含指向父结点的指针。*/

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        if (pNode.right == null) {
            if (pNode.next == null) return null;
            if (pNode.next.left == pNode) {
                return pNode.next;
            } else {
                TreeLinkNode parent = pNode;
                while (parent.next != null) {
                    pNode = parent;
                    parent = parent.next;
                    if (parent.left == pNode) {
                        return parent;
                    }
                }
            }
        }
        return null;
    }


    //思路相同，节省了一个条件判断，更加简洁
    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }
}
