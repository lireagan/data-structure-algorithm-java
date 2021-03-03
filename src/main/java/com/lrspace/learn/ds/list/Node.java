package com.lrspace.learn.ds.list;

/**
 * Author: llx
 * Description: 链表的数据节点
 * Date: 2021/03/03
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
