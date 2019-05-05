package Offer64;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    /*给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值*/
    //使用一个大顶堆来维护窗口最大值
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size > num.length || size < 1) return list;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        //大顶堆先装入滑动窗口数量的元素
        for (int i = 0; i < size; i++) {
            heap.offer(num[i]);
        }
        //添加滑动窗口最大值
        list.add(heap.peek());
        //移动窗口
        for (int i = 0, j = size; j < num.length; i++, j++) {
            heap.remove(num[i]);
            heap.offer(num[j]);
            list.add(heap.peek());
        }
        return list;
    }
}
