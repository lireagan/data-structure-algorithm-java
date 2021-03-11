package com.lrspace.learn.ds.list;

/**
 * Author: llx
 * Description: 链表的数据节点
 * Date: 2021/03/03
 */
public class MNode<E> {
    /* 数据域 */
    public E data;
    /* 单向链表的指针域指向下一个节点 */
    public MNode next;

    public MNode(E data) {
        this.data = data;
    }
}
