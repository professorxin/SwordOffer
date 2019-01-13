package Offer45;

import java.util.Arrays;

public class Solution {
    /*题目描述
    LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
    想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My
    God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可
    以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然
    后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。*/

    //先把数组进行排序，然后计算出小王大王的个数，然后遍历排序的数组，相差大于1的补充小王大王，个数小于0就无法构成顺子
    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) return false;
        Arrays.sort(numbers);
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) count++;
        }
        for (int i = count + 1; i < numbers.length; i++) {
            if (numbers[i] - numbers[i - 1] >= 1) {
                count -= numbers[i] - numbers[i - 1] - 1;
            } else {
                return false;
            }
            if (count < 0) return false;
        }
        return true;
    }



    //思路相同，代码更加优雅
    public boolean isContinuous1(int[] nums) {
        if (nums.length < 5)
            return false;
        Arrays.sort(nums);
        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;
        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;
        }
        return cnt >= 0;
    }
}
