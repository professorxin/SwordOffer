package Offer50;

public class Solution {

    /*题目描述
    在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
    也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
    那么对应的输出是第一个重复的数字2。*/


    //将值为i的元素移动到下标为i的位置上，由于一定存在重复的元素，如果某个元素的值与该值对应下标的值相同，则返回true
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) return false;
        for (int m = 0; m < length; m++) {
            while (m != numbers[m]) {
                if (numbers[m] == numbers[numbers[m]]) {
                    duplication[0] = numbers[m];
                    return true;
                }
                swap(numbers, m, numbers[m]);
            }
        }
        return false;
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String args[]){
        int numbers[]=new int[]{1,2,3,4,1};
        int duplication[]=new int[]{0};
        System.out.println(new Solution().duplicate(numbers,5,duplication));

    }
}
