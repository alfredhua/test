package com.leetcode.of;

import java.util.Stack;

class CQueue {

    private Stack<Integer> enterStack;
    private Stack<Integer> exitStack;
    public CQueue() {
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
}