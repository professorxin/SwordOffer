package Offer64;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    //使用一个大顶堆来维护窗口最大值
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size > num.length || size < 1) return list;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            heap.offer(num[i]);
        }
        list.add(heap.peek());
        for (int i = 0, j = size; j < num.length; i++, j++) {
            heap.remove(num[i]);
            heap.offer(num[j]);
            list.add(heap.peek());
        }
        return list;
    }
}
