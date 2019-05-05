package Offer56;


public class Solution {
    /*题目描述
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     例如，链表1->2->3->3->4->4->5 处理后为 1->2->5*/

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //分为了一开始结点相同和不同的情况讨论，对不同情况进行不同的递归调用。
    public ListNode deleteDuplication(ListNode pHead) {
        //递归终止条件
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode after = pHead.next;
        //如果两个结点的值相同的情况，继续比较之后的结点，直到找到不同的结点，然后用这个不同的结点进行递归
        if (pHead.val == after.val) {
            while (after != null && pHead.val == after.val) {
                after = after.next;
            }
            return deleteDuplication(after);
        } else {
            //结点值不同，头指针的下一个结点为下一个结点进行递归后返回的结点
            pHead.next = deleteDuplication(after);
            return pHead;
        }
    }
}
