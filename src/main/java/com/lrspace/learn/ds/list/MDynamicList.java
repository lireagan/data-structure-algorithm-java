package com.lrspace.learn.ds.list;

/**
 * Author: llx
 * Description: 动态顺序表
 * Date: 2021/2/15
 */
public class MDynamicList<E> {
    private static final int DEFAULT_CAPACITY = 10; // 默认初始化的容量
    private E[] data; // 底层是数组
    private int size; // 记录顺序表已有的数据元素个数

    public MDynamicList(int size) {
        data = (E[]) new Object[size];
        this.size = 0;
    }

    public MDynamicList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 返回顺序表的元素个数
     *
     * @return 已有元素个数
     */
    public int size() {
        return this.size;
    }

    /**
     * 在末尾添加数据元素
     *
     * @param newE 待添加的元素
     */
    public void add(E newE) {
        /* 如果顺序表已满，则需要扩容 */
        if (size == data.length) {
            E[] data_ = data;
            data = (E[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                data[i] = data_[i];
            }
        }
        data[size] = newE;
        size++;
    }

    /**
     * 插入数据元素
     *
     * @param pos  待插入的位置
     * @param newE 待插入的元素
     */
    public void insert(int pos, E newE) {
        if (pos >= size || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        /* 如果顺序表已满，则需要扩容 */
        if (size == data.length) {
            E[] data_ = data;
            data = (E[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                data[i] = data_[i];
            }
        }
        for (int i = size - 1; i >= pos; i--) {
            data[i + 1] = data[i];
        }
        data[pos] = newE;
        size++;
    }

    /**
     * 删除数据元素
     *
     * @param pos 待删除元素的位置
     */
    public void delete(int pos) {
        if (pos >= size || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        for (int i = pos; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    /**
     * 更新数据元素
     *
     * @param pos  待更新元素的位置
     * @param newE 待更新成为的元素
     */
    public void update(int pos, E newE) {
        if (pos >= size || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        data[pos] = newE;
    }

    /**
     * 按下标查询
     *
     * @param pos 待查询的位置
     * @return 查询出的元素
     */
    public E select(int pos) {
        if (pos >= size || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        return data[pos];
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (int i = 0; i < size; i++) {
            out.append(data[i].toString());
            out.append(", ");
        }
        if (size > 0) {
            out.delete(out.length() - 2, out.length());
        }
        out.append("]");
        return out.toString();
    }
}
