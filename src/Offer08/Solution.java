package Offer08;

import java.util.Stack;

public class Solution {

    /*题目描述
    用两个栈来实现一个队列，完成队列的Push和Pop操作。
    队列中的元素为int类型。*/


    //我的思路是执行队列的入操作时先将元素入栈1，出栈时将元素放入栈2后再出栈，这样就能达到先进先出
    //这样还是不够的，入队列时要先判断栈2是否还有元素，如果有元素就先把栈2的元素放进入栈1，
    // 因为栈2还剩余元素的话表示里面的元素是先到达的。
    //缺点是时间空间开销太大了
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }


    /*查看牛客网的讨论区，减少时间空间开销的思路*/

    public void push1(int node) {
        stack1.push(node);
    }

    public int pop1() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
