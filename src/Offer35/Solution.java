package Offer35;

public class Solution {

    /*题目描述
    在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
    求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007*/


    //这道题目直接使用归并排序，只需在归并排序的判断大小位置去进行逆序对统计即可

    //逆序对的数量
    long result = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 1) return 0;
        mergeSort(array, 0, array.length - 1);
        return (int) (result % 1000000007);
    }

    public void mergeSort(int[] array, int index, int end) {
        if (index == end) return;
        int mid = index + (end - index) / 2;
        mergeSort(array, index, mid);
        mergeSort(array, mid + 1, end);
        merge(array, index, mid, end);
    }

    public void merge(int[] array, int index, int mid, int end) {
        int[] help = new int[end - index + 1];
        int i = 0, p1 = index, p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            //下面注释的这一步是原本的归并排序
            //help[i++]=array[p1]<array[p2]?array[p1++]:array[p2++];
            if (array[p1] < array[p2]) {
                help[i++] = array[p1++];
            } else {
                //逆序对统计
                result += mid - p1 + 1;
                help[i++] = array[p2++];
            }
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= end) {
            help[i++] = array[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            array[index + j] = help[j];
        }
    }

    public static void main(String args[]) {
        int[] array = new int[]{1, 7, 3, 5};
        System.out.println(new Solution().InversePairs(array));
    }
}
