package Offer32;

import java.util.Arrays;

public class Solution {
    /*题目描述
    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。*/

    //先转成字符串，两个字符串a,b分别合并成ab和ba,ab小则a排在前面，ba小则b排在前面
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null ||numbers.length==0){
            return "";
        }
        int size=numbers.length;
        String[] nums=new String[size];
        for(int i=0;i<size;i++){
            nums[i]=numbers[i]+"";
        }
        Arrays.sort(nums,(s1,s2)->(s1+s2).compareTo(s2+s1));
        String result="";
        for(String str:nums){
            result+=str;
        }
        return result;
    }
}
