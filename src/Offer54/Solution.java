package Offer54;

public class Solution {
    /*题目描述
    请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的
    字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。*/

    //使用一个字符串保存字符流顺序，使用一个桶来统计字符流的各个字符出现次数
    int nums[] = new int['z' + 1];
    StringBuilder sb = new StringBuilder("");

    public void Insert(char ch) {
        sb.append(ch);
        nums[ch]++;
    }

    public char FirstAppearingOnce() {
        for (int i = 0; i < sb.length(); i++) {
            if (nums[sb.charAt(i)] == 1) {
                return sb.charAt(i);
            }
        }
        return '#';
    }


    public static void main(String args[]) {

    }

}
