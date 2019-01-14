package Offer61;

public class Solution {

    /*题目描述
    请实现两个函数，分别用来序列化和反序列化二叉树*/

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    private String s;

    String Serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        s=str;
        return Deserialize();
    }

    //新建这个函数是为了解决叶子结点处理完左子树为空之后，字符串要有变化，才能去处理右子树。所以字符串是类属性。
    TreeNode Deserialize() {
        if (s.length() == 0) return null;
        int index = s.indexOf(" ");
        String node = index == -1 ? s : s.substring(0, index);
        s = index == -1 ? "" : s.substring(index + 1);
        if (node.equals("#")) return null;
        TreeNode t = new TreeNode(Integer.valueOf(node));
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

    public static void main(String agrs[]) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(new Solution().Serialize(t1));
        System.out.println(new Solution().Deserialize("8 6 5 # # 7 # # 10 9 # # 11 # #"));
    }
}
