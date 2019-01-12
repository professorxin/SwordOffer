package Offer34;

import java.util.HashMap;

public class Solution {

    /*题目描述
    在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
    如果没有则返回 -1（需要区分大小写）.*/


    public int FirstNotRepeatingChar(String str) {
        int[] nums = new int['z' + 1];
        //统计字符串每个字符的出现次数
        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i)]++;
        }
        //第一个字符的次数为1时，返回位置
        for (int i = 0; i < str.length(); i++) {
            if (nums[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
