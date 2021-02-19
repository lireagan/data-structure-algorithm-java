package com.lrspace.learn.ds.list;

/**
 * Author: llx
 * Description: 单向链表（首元节点的下标是0）
 * Date: 2021/2/16
 */
public class MLinkList<E> {
    /**
     * 节点
     */
    public class Node<E> {
        /* 数据域 */
        public E data;
        /* 单向链表的指针域指向下一个节点 */
        public Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    /* 头节点 */
    private Node head;
    /* 当前数据元素个数 */
    private int size;

    /**
     * 返回头节点
     *
     * @return 头节点
     */
    public Node getHead() {
        return head;
    }

    /**
     * 返回当前链表含有的数据元素个数
     *
     * @return size个数
     */
    public int size() {
        return size;
    }

    /**
     * 初始化单向链表（首元节点的下标是0）
     */
    public MLinkList() {
        head = new Node(null); // 头节点数据域为空
        size = 0;
    }

    /**
     * 在末尾添加数据元素
     *
     * @param data 待添加的数据元素
     */
    public void add(E data) {
        Node tmp = new Node(data);
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tmp;
        size++;
    }

    /**
     * 插入数据元素
     *
     * @param pos  待插入的位置
     * @param data 待插入的数据
     */
    public void insert(int pos, E data) {
        if (pos >= size || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        Node tmp = new Node(data);
        Node cur = head;
        if (pos == 0) {
            cur = cur.next;
            head.next = tmp;
            tmp.next = cur;
            return;
        }
        for (int i = 0; i < pos; i++) {
            cur = cur.next;
        }
        Node curNext = cur.next;
        cur.next = tmp;
        tmp.next = curNext;
        size++;
    }

    /**
     * 删除数据元素
     *
     * @param pos 待删除数据元素的位置
     */
    public void delete(int pos) {
        if (pos >= size || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        if (pos == 0) {
            head.next = head.next.next;
            return;
        }
        Node cur = head;
        for (int i = 0; i < pos; i++) {
            cur = cur.next;
        }
        Node curNext = cur.next;
        cur.next = curNext.next;
        size--;
    }

    /**
     * 更新数据元素
     *
     * @param pos  待更新数据元素的位置
     * @param data 待更新数据元素的目标值
     */
    public void update(int pos, E data) {
        if (pos >= size || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        Node cur = head;
        for (int i = 0; i < pos + 1; i++) {
            cur = cur.next;
        }
        cur.data = data;
    }

    /**
     * 查询数据元素
     *
     * @param pos 带查询数据元素的位置
     * @return 查询出的数据元素
     */
    public E select(int pos) {
        if (pos >= size || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        Node cur = head;
        for (int i = 0; i < pos + 1; i++) {
            cur = cur.next;
        }
        return (E) cur.data;
    }

    @Override
    public MLinkList clone() {
        MLinkList mLinkList_ = new MLinkList();
        if(this.size == 0) {
            return mLinkList_;
        }
        Node cur = this.head.next;
        Node cur_ = new Node(cur.data);
        mLinkList_.head.next = cur_;
        mLinkList_.size = 1;

        while(cur.next != null) {
            Node curNext = cur.next;
            Node curNext_ = new Node(curNext.data);
            cur_.next = curNext_;

            cur_ = curNext_;
            cur = curNext;

            mLinkList_.size++;
        }
        return mLinkList_;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        Node cur = head;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            out.append(cur.data.toString());
            out.append(", ");
        }
        if (size > 0) {
            out.delete(out.length() - 2, out.length());
        }
        out.append("]");
        return out.toString();
    }
}
