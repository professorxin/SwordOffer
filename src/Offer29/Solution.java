package Offer29;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    /*题目描述
    输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。*/


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length<k||k<=0) return new ArrayList<>();
        //优先级队列，具体实现是堆，如下是建立一个大顶堆
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(k,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<input.length;i++){
            //添加元素进大顶堆
            maxHeap.offer(input[i]);
            //如果堆的大小大于k，就从k+1里面出一个堆顶元素，也就是里面的最大值
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
