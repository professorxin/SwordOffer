package Offer30;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    /*题目描述
    HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
    常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
    并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
    给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)*/

    //暴力解法，复杂度应该是O(n^2)
    public int FindGreatestSumOfSubArray(int[] array) {
        //大顶堆
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });
        int temp=0;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                temp+=array[j];
                queue.add(temp);
            }
            temp=0;
        }
        return queue.poll();
    }

    public static void main(String args[]){
        int[] array={1,-2,3,10,-4,7,2,-5};
        new Solution().FindGreatestSumOfSubArray(array);
    }


    //如果总和变得小于0,那么从下一个正数重新开始，确保能取到连续子数组最大和
    //如果遇到负数，就保存当前的最大值，应为有可能就是答案
    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : array) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }
}
