package Offer10;

public class Solution {
    /*题目描述
    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
    请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？*/


    //牛客网高票答案
    /*斐波那契数列
    2*n的大矩形，和n个2*1的小矩形
    其中2*target为大矩阵的大小
    有以下几种情形：
    target <= 0 大矩形为<= 2*0,直接return 0；
    target = 1大矩形为2*1，只有一种摆放方法，return1；
    target = 2 大矩形为2*2，有两种摆放方法，return2；
    target = n 分为两步考虑：
    第一次摆放一块 2*1 的小矩阵(竖着放)，则摆放方法总共为f(target - 1)
    第一次摆放一块1*2的小矩阵(横着放)，则摆放方法总共为f(target-2)*/
    public int RectCover(int target) {
        if(target  <= 0){
            return 0;
        }else if(target <= 2){
            return target;
        }else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }
}
