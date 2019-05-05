package Offer55;

public class Solution {
    /*题目描述
    给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。*/

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*这个的思路是通过定义一快一慢的指针，快的指针是慢的两倍，从而找到相遇的结点，
    然后通过这个相遇的节点找出整个环的结点数目，找到结点数目之后，再定义两个指针，
    让里面的一个指针先移动结点数目，然后两个指针再同时移动，相遇点就是入口结点*/

    //找到一快一满指针相遇处的节点，相遇的节点一定是在环中
    public ListNode meetingNode(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head.next;
        if (slow == null)
            return null;

        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;

            if (fast != slow) {
                fast = fast.next;
            }
        }
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null)
            return null;
//      得到环中的节点个数
        int nodesInLoop = 1;
        ListNode p1 = meetingNode;
        while (p1.next != meetingNode) {
            p1 = p1.next;
            ++nodesInLoop;
        }
//      移动p1
        p1 = pHead;
        for (int i = 0; i < nodesInLoop; i++) {
            p1 = p1.next;
        }
//      移动p1，p2
        ListNode p2 = pHead;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }


    //这个思路比较巧妙，利用到了数学的推倒，得到等价关系，图片在images文件夹
    /*使用双指针，一个指针 fast 每次移动两个节点，一个指针 slow 每次移动一个节点。
    因为存在环，所以两个指针必定相遇在环中的某个节点上。假设相遇点在下图的 y6 位置，
    此时 fast 移动的节点数为 x+2y+z，slow 为 x+y，由于 fast 速度比 slow 快一倍，
    因此 x+2y+z=2(x+y)，得到 x=z。在相遇点，slow 要到环的入口点还需要移动 z 个节点，
    如果让 fast 重新从头开始移动，并且速度变为每次移动一个节点，那么它到环入口点还需
    要移动 x 个节点。在上面已经推导出 x=z，因此 fast 和 slow 将在环入口点相遇。*/

    //但是上面这个演示的只是一般性的推倒，准确来说x=n个环的长度+z
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
