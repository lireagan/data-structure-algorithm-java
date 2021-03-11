package com.lrspace.learn.ds.list;

/**
 * Author: llx
 * Description: 链栈
 * Date: 2021/03/11
 */
public class MLinkStack<E> {
    private MNode<E> head; // 头结点

    public MLinkStack() {
        head = new MNode(null);
        head.next = null;
    }

    public MNode getHead() {
        return head;
    }

    /**
     * 获取栈的长度
     *
     * @return
     */
    public int size() {
        MNode cur = head.next;
        if (cur == null) {
            return 0;
        }
        int size = 1;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    /**
     * 元素入栈
     *
     * @param e
     */
    public void push(E e) {
        MNode cur = head.next;
        if (cur == null) {
            head.next = new MNode(e);
            return;
        }
        head.next = new MNode(e);
        head.next.next = cur;
    }

    /**
     * 元素出栈
     *
     * @return 元素
     */
    public E pop() {
        MNode cur = head.next;
        if (cur == null) {
            return null;
        }
        E out = (E) cur.data;
        head.next = cur.next;
        return out;
    }

    @Override
    public String toString() {
        MNode cur = head;
        if (cur.next == null) {
            return "[]";
        }
        StringBuilder out = new StringBuilder();
        out.append("[");
        while (cur.next != null) {
            cur = cur.next;
            out.append(cur.data.toString());
            out.append(", ");
        }
        out.delete(out.length() - 2, out.length());
        out.append("]");
        return out.toString();
    }
}
