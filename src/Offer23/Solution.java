package Offer23;

public class Solution {
    /*题目描述
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
    假设输入的数组的任意两个数字都互不相同。*/

    public boolean VerifySquenceOfBST(int[] sequence) {
        //如果数组为空或者长度为0，则返回false
        if (sequence == null || sequence.length == 0) return false;
        return Verify(sequence, 0, sequence.length - 1);
    }

    public boolean Verify(int[] sequence, int index, int end) {
        //递归结束条件，如果index>=end表明只有一个结点或者没有，则它的顺序肯定是正确的
        if (index >= end) return true;
        //找出根节点的值
        int root = sequence[end];
        int i = index;
        //找出左子树的部分
        while (root > sequence[i]) {
            i++;
        }
        //标识符，用于记录左子树和右子树的分割位置，用于之后的递归传参
        int temp = i;
        //对右子树部分进行判断
        while (i <= end) {
            //判断右子树是否右小于根节点的值，有的话表示不满足二叉搜索树的定义，则返回false;
            if (sequence[i] < root) return false;
            i++;
        }
        //递归调用左子树和右子树，判断其是否满足二叉搜索树
        return Verify(sequence, index, temp - 1) && Verify(sequence, temp, end - 1);
    }

    public static void main(String args[]) {
        int[] a = new int[]{4, 8, 6, 12, 16, 14, 10};
        new Solution().VerifySquenceOfBST(a);
    }
}
