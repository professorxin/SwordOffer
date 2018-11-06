package Offer04;

public class Solution {
/*    题目描述
    一只青蛙一次可以跳上1级台阶，也可以跳上2级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。*/

    public int JumpFloor(int target) {
        if(target==1) return 1;
        if(target==2) return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    /*牛客网其他解法，避免递归，提高效率*/
    int jumpFloor1(int number) {

        if (number < 2)
            return number;
        int f1 = 1;
        int f2 = 0;
        int f = 0;
        for (int i = 1; i <= number; ++i) {
            f = f1 + f2;
            f2 = f1;
            f1 = f;
        }
        return f;
    }

    public static void main(String args[]){
        System.out.println(new Solution().JumpFloor(7));
    }
}
