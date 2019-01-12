package Offer27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {
    /*题目描述
    输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

    输入描述:
    输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。*/


    //牛客网高分答案，采用回溯的思想
    //帮助理解的图片在images文件夹内

    public ArrayList<String> Permutation(String str) {
        //保存所需答案的集合
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            //将str转成数组，传入字符串的首位和保存集合
            PermutationHelper(str.toCharArray(), 0, res);
            //对集合的答案排序，形成字典序
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    public void PermutationHelper(char[] cs, int i, List<String> list) {
        //i表示记录当前元素在数组中的位置，如果i位置取出的元素在元素末尾，表明该字符串已经完成排序
        if (i == cs.length - 1) {
            //数组转化为字符串
            String val = String.valueOf(cs);
            //判断集合中是否包含该字符串，不包含才添加
            if (!list.contains(val))
                list.add(val);
        } else {
            //令j为i现在的位置，让j后面的每个元素都和i做交换
            for (int j = i; j < cs.length; j++) {
                //交换i和j位置对应的元素
                swap(cs, i, j);
                //递归调用函数，i+1的原因是交换完一次顺序i就加1，从而才能判断现在i是否在末尾
                PermutationHelper(cs, i + 1, list);
                //调用完成之后再将i和j调换，恢复之前的顺序来执行下一个for循环
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.Permutation("aa").toString());
    }
}
