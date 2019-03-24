package Offer20;

import java.util.Stack;

public class Solution {
    /*题目描述
    定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。*/

    //正常数据的栈
    private Stack<Integer> dataStack = new Stack<>();
    //辅助栈，保持栈顶元素为最小值
    private Stack<Integer> minStack = new Stack<>();


    public void push(int node) {
        dataStack.push(node);
        //如果辅助栈为空,就加入这个元素。如果辅助栈不为空，就判断所加入结点和栈顶结点的大小，小的进
        if (minStack.empty()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek() > node ? node : minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    //栈顶元素，这个要使用原始栈返回
    public int top() {
        return dataStack.peek();
    }

    //最小元素，这个要使用辅助栈返回
    public int min() {
        return minStack.peek();
    }
}
