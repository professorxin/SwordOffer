package Offer14;

import java.util.Stack;

public class Solution {
    /*题目描述
    输入一个链表，输出该链表中倒数第k个结点。*/

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //通过while循环先把链表结点数算出来，然后再控制头结点走到倒数的第k个结点的地方
    public ListNode FindKthToTail(ListNode head,int k) {
        int number=0;
        ListNode node=new ListNode(0);
        node=head;
        while(head!=null){
            number++;
            head=head.next;
        }
        //如果倒数的第k个结点比总结点数大，返回空
        if(k>number) return null;
        for(int i=0;i<number-k;i++){
            node=node.next;
        }
        return node;
    }


    /*牛客网高票答案*/
    //只用一个循环就可以得出答案，思路体现在q结点一直保持在倒数第k个结点的位置，这样链表遍历完之后就可以直接得出答案了
    public ListNode FindKthToTail1(ListNode head,int k) { //5,{1,2,3,4,5}
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }

    public static void main(String agrs[]){
/*        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        node3.next=null;
        System.out.println(FindKthToTail(node1,1).val);*/
    }

}
