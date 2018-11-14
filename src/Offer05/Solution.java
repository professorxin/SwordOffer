package Offer05;

public class Solution {
    /*题目描述
    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法。*/

    //很暴力的解法，找到了数学规律
    public int JumpFloorII(int target) {
        if(target<=0) return 0;
        if(target==1) return 1;
        if(target==2) return 2;
        int temp=3,all_ways=0;
        for(int i=2;i<target;i++){
            all_ways+=temp;
            temp=all_ways;
            all_ways+=1;
        }
        return all_ways;
    }

    //牛客网高票解法
    //找规律
    /*f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
    f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
    f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
    可以得出：
    f(n) = 2*f(n-1)*/

    public int JumpFloorII1(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII1(target - 1);
        }
    }
}
