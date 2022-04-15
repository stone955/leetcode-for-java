package com.stone.leetcode.datastruct;

import java.util.Stack;

/**
 * MyQueue
 * 使用两个栈实现队列
 */
public class DoubleStackForQueue {

    private Stack<Integer> in, out;

    public DoubleStackForQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        this.in.push(x);
    }

    public int pop() {
        if (this.out.empty()) {
            while (!this.in.empty()) {
                this.out.push(this.in.pop());
            }
        }
        return this.out.pop();
    }

    public int peek() {
        if (this.out.empty()) {
            while (!this.in.empty()) {
                this.out.push(this.in.pop());
            }
        }
        return this.out.peek();
    }

    public boolean empty() {
        return this.in.empty() && this.out.empty();
    }
}
