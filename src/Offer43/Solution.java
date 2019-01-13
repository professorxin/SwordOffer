package Offer43;

public class Solution {
    /*题目描述
    汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
    对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环
    左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！*/


    public String LeftRotateString(String str, int n) {
        int len = str.length();
        if (len == 0) return "";
        //n可能大于字符串的长度，要进行取余
        n = n % len;
        //两个相同的字符串拼接起来
        str += str;
        //截取n到n+len位置的字符串
        return str.substring(n, len + n);
    }

    public static void main(String args[]) {
        System.out.println(new Solution().LeftRotateString("", 6));
    }


    //没有使用内置函数的做法，进行了三次翻转
    public String LeftRotateString1(String str, int n) {
        if (n >= str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
