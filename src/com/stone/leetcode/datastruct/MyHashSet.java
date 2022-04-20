package com.stone.leetcode.datastruct;

/**
 * MyHashSet
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
class MyHashSet {

    private int[] _buckets = new int[40000];

    public void add(int key) {
        int bucketIdx = key / 32; // 确定桶
        int bitIdx = key % 32; // 确定桶内的位置
        setValue(bucketIdx, bitIdx, true);
    }


    public void remove(int key) {
        int bucketIdx = key / 32; // 确定桶
        int bitIdx = key % 32; // 确定桶内的位置
        setValue(bucketIdx, bitIdx, false);
    }

    public boolean contains(int key) {
        int bucketIdx = key / 32; // 确定桶
        int bitIdx = key % 32; // 确定桶内的位置
        return getValue(bucketIdx, bitIdx);
    }


    private void setValue(int bucketIdx, int loc, boolean val) {
        // 位运算
        int u;
        if (val) {
            u = _buckets[bucketIdx] | (1 << loc);
        } else {
            u = _buckets[bucketIdx] & ~(1 << loc);
        }
        _buckets[bucketIdx] = u;
    }

    private boolean getValue(int bucketIdx, int loc) {
        int u = (_buckets[bucketIdx] >> loc) & 1;
        return u == 1;
    }
}