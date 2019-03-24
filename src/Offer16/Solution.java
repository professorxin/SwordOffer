package Offer16;

public class Solution {

    /*题目描述
    输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。*/

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //利用递归
    public ListNode Merge(ListNode list1, ListNode list2) {
        //终结条件
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        //如果list1的结点值小于list2的结点值，就先取到list1的结点值，list1后面的结点和list2递归
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
