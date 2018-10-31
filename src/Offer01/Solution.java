package Offer01;

public class Solution {
    /*题目描述
    在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
    判断数组中是否含有该整数。*/


    /*本人解法，不优雅*/
    public boolean Find(int target, int [][] array) {
        if(array==null) return false;
        int row=array.length;
        int column=array[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(array[i][j]==target) return true;
                if(array[i][j]>target) break;
            }
        }
        return false;
    }


    /* 牛客网高票答案思路
     * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
     * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
     * 要查找数字比左下角数字小时，上移
     */
    public boolean Find1(int target,int [][] array) {
        int len = array.length-1;
        int i = 0;
        while((len >= 0)&& (i < array[0].length)){
            if(array[len][i] > target){
                len--;
            }else if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]){
        int [][]array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new Solution().Find1(7,array));
    }
}
