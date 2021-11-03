package com.leetcode.of;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 */
class J01CQueue {
    private Stack<Integer> enterStack;
    private Stack<Integer> exitStack;
    public J01CQueue() {
        enterStack=new Stack<>();
        exitStack=new Stack<>();
    }
    public void appendTail(int value) {
        if (exitStack.isEmpty()){
            exitStack.push(value);
        }else{
            while (!exitStack.isEmpty()){
                enterStack.push(exitStack.pop());
            }
            exitStack.push(value);
            while (!enterStack.isEmpty()){
                exitStack.push(enterStack.pop());
            }
        }
    }
    public int deleteHead() {
        if (exitStack.isEmpty()){
            return -1;
        }
        return exitStack.pop();
    }

    public static void main(String[] args) {
        J01CQueue cQueue = new J01CQueue();
        cQueue.deleteHead();
        cQueue.appendTail(3);
        cQueue.deleteHead();
        cQueue.deleteHead();
    }
}