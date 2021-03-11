package com.lrspace.learn.ds.list;

/**
 * Author: llx
 * Description: 顺序存储结构栈
 * Date: 2021/03/11
 */
public class MSequenceStack<E> {
    private E[] stack = null;
    private int size = 0; // 栈中的元素个数

    /**
     * 初始化顺序栈
     *
     * @param capacity 容量
     */
    public MSequenceStack(int capacity) {
        stack = (E[]) new Object[capacity];
    }

    /**
     * 获取栈的长度
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 元素入栈
     *
     * @param e
     */
    public void push(E e) {
        if (size == stack.length) {
            throw new IllegalArgumentException("the stack is full!");
        }
        for (int i = size; i > 0; i--) {
            stack[i] = stack[i - 1];
        }
        stack[0] = e;
        this.size++;
    }

    /**
     * 元素出栈
     *
     * @return 栈顶元素
     */
    public E pop() {
        if (size == 0) {
            throw new IllegalArgumentException("the stack is empty!");
        }
        E out = stack[0];
        for (int i = 0; i < size; i++) {
            stack[i] = stack[i + 1];
        }
        size--;
        return out;
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[]";
        }
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (int i = 0; i < this.size(); i++) {
            out.append(this.stack[i].toString());
            out.append(", ");
        }
        if (this.size() > 0) {
            out.delete(out.length() - 2, out.length());
        }
        out.append("]");
        return out.toString();
    }

}
