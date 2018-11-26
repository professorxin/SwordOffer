package Offer28;

import java.util.Arrays;

public class Solution {
    /*题目描述
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
    超过数组长度的一半，因此输出2。如果不存在则输出0。*/

    //本人思路，先把数组排序，有一个标识位来表示元素在数组中出现的次数，如果大于数组长度一半就返回。
    //但是排序的时间复杂度为O(n*logn)
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==1) return array[0];
        Arrays.sort(array);
        int length=array.length;
        int index=1;
        for(int i=1;i<length;i++){
            if(array[i]==array[i-1]){
                index++;
                if(index>length/2) return array[i];
            }else{
                index=1;
            }
        }
        return 0;
    }

    //他人思路，时间复杂度为O(n)
    /*多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。

    使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 cnt++，否则令 cnt--。
    如果前面查找了 i 个元素，且 cnt == 0，说明前 i 个元素没有 majority，或者有 majority，
    但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。此时剩下的 n - i 个元素中，
    majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。*/

    public int MoreThanHalfNum_Solution1(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            //如果相同元素出现，统计次数就加1，否则就减1
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            //等于0重新标记元素
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        //最后的majority要不就是最末尾的元素？或者是出现次数最多的元素，所以需要遍历判断
        int cnt = 0;
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }

    public static void main(String args[]){
        //int[] nums=new int[]{1,2,3,2,2,2,5,4,2};
        int[] nums=new int[]{2,2,2,2,3,3,3,5,6};
        new Solution().MoreThanHalfNum_Solution1(nums);
    }
}
