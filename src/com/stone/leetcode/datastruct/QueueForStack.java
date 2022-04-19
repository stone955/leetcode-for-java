package com.stone.leetcode.datastruct;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * QueueForStack
 * <p>
 * 使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 */
public class QueueForStack {
    private Deque<Integer> _data;

    public QueueForStack() {
        this._data = new ArrayDeque<>();
    }

    public void push(int x) {
        this._data.addLast(x);
    }

    public int pop() {
        int size = this._data.size();
        while (size-- > 1) {
            this._data.addLast(_data.pollFirst());
        }
        return this._data.pollFirst();
    }

    public int top() {
        int size = this._data.size();
        while (size-- > 1) {
            this._data.addLast(this._data.pollFirst());
        }
        int u = this._data.peekFirst();
        this._data.addLast(this._data.pollFirst());
        return u;
    }

    public boolean empty() {
        return this._data.isEmpty();
    }
}
