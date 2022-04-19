package com.stone.leetcode.datastruct;

/**
 * TripleInOne
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * 0 <= stackNum <= 2
 */
public class TripleInOne {

    /**
     * 方法一：二维数组
     */

//    private int N = 3;
//
//    // 3 * n 的数组，每一行代表一个栈
//    private int[][] data;
//
//    // 记录每个栈「待插入」位置
//    int[] locations;
//
//    public TripleInOne(int stackSize) {
//        this.data = new int[N][stackSize];
//        this.locations = new int[N];
//    }
//
//    public void push(int stackNum, int value) {
//        int[] stack = this.data[stackNum];
//        int location = this.locations[stackNum];
//        if (location > stack.length - 1) {
//            return;
//        }
//
//        stack[location] = value;
//        this.locations[stackNum]++;
//    }
//
//    public int pop(int stackNum) {
//        int[] stack = this.data[stackNum];
//        int location = this.locations[stackNum];
//        if (location > 0) {
//            int value = stack[location - 1];
//            this.locations[stackNum]--;
//            return value;
//        } else {
//            return -1;
//        }
//    }
//
//    public int peek(int stackNum) {
//        int[] stack = this.data[stackNum];
//        int location = this.locations[stackNum];
//        if (location > 0) {
//            return stack[location - 1];
//        } else {
//            return -1;
//        }
//    }
//
//    public boolean isEmpty(int stackNum) {
//        return this.locations[stackNum] == 0;
//    }

    /**
     * 方法二：一维数组
     */

    private int N = 3;

    // 3 * n 的数组，每一行代表一个栈
    private int[] data;

    // 记录每个栈「待插入」位置
    private int[] locations;

    private int size;

    public TripleInOne(int stackSize) {
        this.size = stackSize;
        this.data = new int[this.N * this.size];
        this.locations = new int[N];
        for (int i = 0; i < N; i++) {
            this.locations[i] = i * this.size;
        }
    }

    public void push(int stackNum, int value) {
        int loc = this.locations[stackNum];
        if (loc < (stackNum + 1) * this.size) {
            this.data[loc] = value;
            this.locations[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int loc = this.locations[stackNum];
        if (loc > stackNum * this.size) {
            int value = this.data[loc - 1];
            this.locations[stackNum]--;
            return value;
        } else {
            return -1;
        }
    }

    public int peek(int stackNum) {
        int loc = this.locations[stackNum];
        if (loc > stackNum * this.size) {
            return this.data[loc - 1];
        } else {
            return -1;
        }
    }

    public boolean isEmpty(int stackNum) {
        return this.locations[stackNum] == stackNum * size;
    }
}
