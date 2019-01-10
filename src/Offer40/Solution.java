package Offer40;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*题目描述
    一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。*/


    //本人思路，使用一个hashmap去存放整型数组的元素和出现的次数，最后遍历hashmap找出出现次数为1的数字
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                Integer value = map.get(array[i]);
                map.put(array[i], value + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        boolean flag = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (flag == true) {
                    num1[0] = entry.getKey();
                    flag = false;
                } else {
                    num2[0] = entry.getKey();
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] array = {2, 1, 3, 6, 3, 2, 5, 5};
        int[] num1 = {0};
        int[] num2 = {0};
        new Solution().FindNumsAppearOnce2(array, num1, num2);
    }



    /*两个不相等的元素在位级表示上必定会有一位存在不同，
    将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。

    diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，
    利用这一位就可以将两个元素区分开来。
    最右侧不为0的位置肯定是由于那两个不相同的数字导致的，所以根据数组里面的数相与diff是否为0可以将数组分成两份，
    每一份里面肯定有一个只出现过一次的数字，两份分别进行相与可以找出两个数*/
    public void FindNumsAppearOnce2(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        System.out.println("前:"+diff);
        diff &= -diff;
        System.out.println("后:"+diff);
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
        System.out.println(num1[0]+"-----"+num2[0]);
    }
}
