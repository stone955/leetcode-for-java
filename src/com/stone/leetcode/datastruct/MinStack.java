package com.stone.leetcode.datastruct;

import java.util.*;

/**
 * MinStack
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class MinStack {

    /**
     * 方法一：双栈解法
     * <p>
     * 为了快速找到栈中最小的元素，我们可以使用一个辅助栈 help。
     * <p>
     * 通过控制 help 的压栈逻辑来实现：help 栈顶中始终存放着栈内元素的最小值。
     */

//    private Deque<Integer> data, min;
//
//
//    public MinStack() {
//        this.data = new ArrayDeque<>();
//        this.min = new ArrayDeque<>();
//    }
//
//    /**
//     * push 双栈同时操作。
//     * data 栈正常操作
//     * min 栈分两种情况，如果 val 小于min 栈顶元素，则直接入栈；否则， 将min 栈顶元素复制压入栈顶。
//     *
//     * @param val
//     */
//    public void push(int val) {
//        this.data.addLast(val);
//        if (this.min.isEmpty() || this.min.peekLast() > val) {
//            this.min.addLast(val);
//        } else {
//            this.min.addLast(this.min.peekLast());
//        }
//    }
//
//    /**
//     * pop
//     * 双栈同时操作。
//     */
//    public void pop() {
//        this.data.pollLast();
//        this.min.pollLast();
//    }
//
//    public int top() {
//        return this.data.peekLast();
//    }
//
//    public int getMin() {
//        return this.min.peekLast();
//    }

    /**
     * 方法二：单栈解法
     */

    private Stack<int[]> stack;


    public MinStack() {
        this.stack = new Stack<>();
    }


    public void push(int val) {
        int min = val;
        if (!this.stack.isEmpty() && this.stack.peek()[1] < val) {
            min = this.stack.peek()[1];
        }

        int[] value = {val, min};

        this.stack.push(value);
    }

    public void pop() {
        this.stack.pop();
    }

    public int top() {
        return this.stack.peek()[0];
    }

    public int getMin() {
        return this.stack.peek()[1];
    }
}
