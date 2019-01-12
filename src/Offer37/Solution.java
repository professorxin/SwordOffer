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
            //奇数的话中点在中间，偶数的话中点在中间两位数的左边那位
            int m = l + (h - l) / 2;
            //判断中点处的值和k值，确定边界条件，这一步要注意边界
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }

    public static void main(String args[]) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3};
        System.out.println(new Solution().GetNumberOfK1(array, 3));
    }


    //自己重新写了一下，边界处理的不好
    public int GetNumberOfK1(int[] array, int k) {
        if (array.length == 0) return 0;
        int first = binarySearch(array, k);
        int last = binarySearch(array, k + 1);
        //如果k存在数组的末尾，那么总数要加一
        if (array[last] == k) return last - first + 1;
        return last - first;
    }

    public int binarySearch1(int[] array, int k) {
        int index = 0;
        int end = array.length - 1;
        while (index < end) {
            int mid = (index + end) / 2;
            if (array[mid] >= k) {
                end = mid;
            } else {
                index = mid + 1;
            }
        }
        return index;
    }
}
