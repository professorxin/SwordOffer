package Offer37;

public class Solution {
    /*题目描述
    统计一个数字在排序数组中出现的次数。*/

    public int GetNumberOfK(int[] nums, int K) {
        //查找出现k的第一个位置
        int first = binarySearch(nums, K);
        //查找出现k+1的位置，为了可以确定k的最后一个位置
        int last = binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }
    //二分查找，注意观察边界的设定
    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }

    public static void main(String args[]){
        int[] array=new int[]{1,2,3,3,3,3,4,5};
        System.out.println(new Solution().GetNumberOfK(array,3));
    }
}
