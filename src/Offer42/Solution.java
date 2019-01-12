package Offer42;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    /*题目描述
    输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
    输出两个数的乘积最小的。*/

    //使用头指针和尾指针，由于是有序的，和小于sum就移动头指针，和大于sum就移动尾指针。
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length == 1) return null;
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0, end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] < sum) {
                start++;
            } else if (array[start] + array[end] > sum) {
                end--;
            } else {
                list.add(array[start]);
                list.add(array[end]);
                return list;
            }
        }
        return list;
    }


    //同样的思路，步骤比较简洁
    public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum)
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            if (cur < sum)
                i++;
            else
                j--;
        }
        return new ArrayList<>();
    }

}
