package Offer25;

import java.util.HashMap;

public class Solution {
    /*题目描述
    输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）*/

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //利用hashmap去保存复制的节点，形成原结点和复制结点一一对应的关系。再遍历链表，根据原链表找到他们复制后的结点的对应关系即可
    //额外空间复杂度为O(n)
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode index = pHead;
        while (index != null) {
            map.put(index, new RandomListNode(index.label));
            index = index.next;
        }
        index = pHead;
        while (index != null) {
            map.get(index).next = map.get(index.next);
            map.get(index).random = map.get(index.random);
            index = index.next;
        }
        return map.get(pHead);
    }

    //将复制的结点放在原先结点的后面，复制结点的random指针可以通过原先结点random指向结点的next来找到，最后拆分好
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null)
            return null;
        // 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }

}
