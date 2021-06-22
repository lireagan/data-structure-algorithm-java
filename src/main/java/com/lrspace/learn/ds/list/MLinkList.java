package com.lrspace.learn.ds.list;

import static com.lrspace.learn.ds.list.AlgoLinkListRing.calcRingLength;
import static com.lrspace.learn.ds.list.AlgoLinkListRing.findRingDoor;

/**
 * Author: llx
 * Description: 单向链表（首元节点的下标是0）
 * Date: 2021/2/16
 */
public class MLinkList<E> {

    /* 头节点 */
    private MNode head;

    /**
     * 返回头节点
     *
     * @return 头节点
     */
    public MNode getHead() {
        return head;
    }

    /**
     * 返回当前链表含有的数据元素个数
     *
     * @return size个数
     */
    public int size() {
        if (head.next == null) {
            return 0;
        }
        MNode cur = head.next;
        MNode ringDoor = findRingDoor(this);
        int size = 1;
        while (cur.next != null && cur.next!=ringDoor) {
            cur = cur.next;
            size++;
        }
        return size + calcRingLength(this);
    }

    /**
     * 初始化单向链表（首元节点的下标是0）
     */
    public MLinkList() {
        head = new MNode(null); // 头节点数据域为空
    }

    /**
     * 在末尾添加数据元素
     *
     * @param data 待添加的数据元素
     */
    public void add(E data) {
        MNode tmp = new MNode(data);
        MNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tmp;
    }

    /**
     * 插入数据元素
     *
     * @param pos  待插入的位置
     * @param data 待插入的数据
     */
    public void insert(int pos, E data) {
        if (pos >= this.size() || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        MNode tmp = new MNode(data);
        MNode cur = head;
        if (pos == 0) {
            cur = cur.next;
            head.next = tmp;
            tmp.next = cur;
            return;
        }
        for (int i = 0; i < pos; i++) {
            cur = cur.next;
        }
        MNode curNext = cur.next;
        cur.next = tmp;
        tmp.next = curNext;
    }

    /**
     * 删除数据元素
     *
     * @param pos 待删除数据元素的位置
     */
    public void delete(int pos) {
        if (pos >= this.size() || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        if (pos == 0) {
            head.next = head.next.next;
            return;
        }
        MNode cur = head;
        for (int i = 0; i < pos; i++) {
            cur = cur.next;
        }
        MNode curNext = cur.next;
        cur.next = curNext.next;
    }

    /**
     * 更新数据元素
     *
     * @param pos  待更新数据元素的位置
     * @param data 待更新数据元素的目标值
     */
    public void update(int pos, E data) {
        if (pos >= this.size() || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        MNode cur = head;
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
        if (pos >= this.size() || pos < 0) {
            throw new IllegalArgumentException("error: the input pos " + pos + " is exceed the bound.");
        }
        MNode cur = head;
        for (int i = 0; i < pos + 1; i++) {
            cur = cur.next;
        }
        return (E) cur.data;
    }

    @Override
    public MLinkList clone() {
        MLinkList mLinkList_ = new MLinkList();
        if (this.size() == 0) {
            return mLinkList_;
        }
        MNode cur = this.head.next;
        MNode cur_ = new MNode(cur.data);
        mLinkList_.head.next = cur_;

        while (cur.next != null) {
            MNode curNext = cur.next;
            MNode curNext_ = new MNode(curNext.data);
            cur_.next = curNext_;

            cur_ = curNext_;
            cur = curNext;
        }
        return mLinkList_;
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
