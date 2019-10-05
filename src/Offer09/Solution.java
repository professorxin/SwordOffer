package Offer09;

public class Solution {
    /*题目描述
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/

    //我的思路是直接两两对比，若前一个比后一个大，证明后一个是最小值
    //时间空间开销太大，这样的解法肯定不行的
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) return array[i];
        }
        return array[0];
    }


    /*参考剑指offer书籍采用了二分查找*/
    public int minNumberInRotateArray1(int[] array) {
        if (array.length == 0) return 0;
        int head = 0;
        int tail = array.length - 1;
        int mid;
        while (array[head] >= array[tail]) {
            mid = (head + tail) / 2;
            if (head == tail - 1) return array[tail];
            if (array[mid] >= array[head]) {
                head = mid;
            } else {
                tail = mid;
            }
        }
        return array[0];
    }


}
