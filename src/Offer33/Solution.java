package Offer33;

public class Solution {
    /*题目描述
    把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
    习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。*/

    /*每一个丑数分别乘以2，3，5都能得出一个新的丑数，这是关键的一步，乘出来的三个丑数取最小的值就是下一个丑数的值，再进行判断是用什么
    乘出来的丑数，该位置+1，然后再进行下一次的三个数比较，保证了数组内的丑数都是有序的*/
    public int GetUglyNumber_Solution(int index) {
        if (index <= 6) return index;
        int[] nums = new int[index];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < index; i++) {
            int next2 = nums[i2] * 2, next3 = nums[i3] * 3, next5 = nums[i5] * 5;
            nums[i] = Math.min(next2, Math.min(next3, next5));
            if (nums[i] == next2) i2++;
            if (nums[i] == next3) i3++;
            if (nums[i] == next5) i5++;
        }
        return nums[index - 1];
    }
}
