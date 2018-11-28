package Offer36;

public class Solution {
    /*题目描述
    输入两个链表，找出它们的第一个公共结点。*/


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //先遍历得出两个链表的长度，然后长的链表先移动他们长度的差值，再控制他们同时移动就可以得出公共结点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null) return null;
        int length1=findLength(pHead1);
        int length2=findLength(pHead2);
        if(length1>length2){
            pHead1=walkFirst(pHead1,length1-length2);
        }else{
            pHead2=walkFirst(pHead2,length2-length1);
        }
        while(pHead1!=null){
            if(pHead1==pHead2) return pHead1;
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return null;
    }

    public int findLength(ListNode node){
        int length=0;
        while(node!=null){
            length++;
            node=node.next;
        }
        return length;
    }

    public ListNode walkFirst(ListNode node,int step){
        while(step-->0){
            node=node.next;
        }
        System.out.println(node.val);
        return node;
    }


    public static void main(String args[]){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        node1.next=node2;
        node2.next=node6;
        node6.next=node7;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        ListNode temp=new Solution().FindFirstCommonNode(node1,node3);
        //System.out.println(temp);
    }


/*  图片在images文件夹
    设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，
    可知 a + c + b = b + c + a。
    当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
    同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
    这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。*/

    //这样在第二次重新访问的时候就能同时到达相同结点，很巧妙的解法
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}
