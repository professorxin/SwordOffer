package Offer06;

import java.util.ArrayList;

public class Solution {
    /*输入一个链表，按链表值从尾到头的顺序返回一个ArrayList*/

    //我先把链表保存到ArrayList里面，再通过循环来交换ArrayList里面的数字，变成从尾到头的顺序
     public class ListNode {
         int val;
         ListNode next = null;
         ListNode(int val) {
             this.val = val;
         }
     }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null) return new ArrayList();
        ArrayList<Integer> list=new ArrayList<>();
        while(listNode!=null){
            list.add(listNode.val);
            listNode=listNode.next;
        }
        int temp,length=list.size()-1;
        for(int i=0;i<=length/2;i++){
            temp=list.get(length-i);
            list.set(length-i,list.get(i));
            list.set(i,temp);
        }
        return list;
    }


    //牛客网高票答案

    //java 递归超简洁版本
    //通过定义一个全局的arrayList，递归调用使得arrayList能从尾到头保存
/*
    public class Solution {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if(listNode!=null){
                this.printListFromTailToHead(listNode.next);
                arrayList.add(listNode.val);
            }
            return arrayList;
        }
    }
*/


}
