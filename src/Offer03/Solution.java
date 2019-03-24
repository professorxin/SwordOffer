package Offer03;

public class Solution {
/*    题目描述
    大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
    n<=39*/

    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }


    /*牛客网解法，动态规划，f相当于f(n),g相当于f(n+1)*/
    public int Fibonacci1(int n) {
        int f = 0, g = 1;
        while (n-- > 0) {
            g += f;
            f = g - f;
        }
        return f;
    }

    public static void main(String args[]) {
        System.out.println(new Solution().Fibonacci1(2));
    }
}
