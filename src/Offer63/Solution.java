package Offer63;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

/*题目描述
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。*/

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });

    public void Insert(Integer num) {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            maxHeap.offer(Integer.MIN_VALUE);
            minHeap.offer(Integer.MAX_VALUE);
        }
        if (num > maxHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() == 2) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double GetMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 1) {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek() * 1.0;
            } else {
                return minHeap.peek() * 1.0;
            }
        } else {
            return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
        }
    }


    public static void main(String args[]) {
        Solution s = new Solution();
        s.Insert(5);
        System.out.println(s.GetMedian());
    }


    //同样的思路，更简洁
    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /* 当前数据流读入的元素个数 */
    private int N = 0;

    public void Insert1(Integer val) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian1() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }

}
