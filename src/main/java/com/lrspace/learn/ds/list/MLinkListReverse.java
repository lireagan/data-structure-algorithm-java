package com.lrspace.learn.ds.list;


/**
 * Author: llx
 * Description: 单链表反转
 * Date: 2021/2/17
 */
public class MLinkListReverse {

    /**
     * 方法一：循环遍历反转
     *
     * @param mLinkList
     * @return 反转后的单链表
     */
    public static MLinkList reverseLoop(MLinkList mLinkList) {
        MLinkList reversedMLinkList = mLinkList.clone(); // 存储反转过后的单链表
        if (reversedMLinkList.size() < 2) {
            return mLinkList;
        }
        Node curPre = reversedMLinkList.getHead().next;
        Node cur = curPre.next;
        curPre.next = null; // 首元节点变成尾节点，指向null

        while (cur.next != null) {
            Node curNext = cur.next;
            cur.next = curPre;
            curPre = cur;
            cur = curNext;
        }
        cur.next = curPre;
        // 头节点指向原来单向链表的尾节点
        reversedMLinkList.getHead().next = cur;

        return reversedMLinkList;
    }

    /**
     * 方法二：递归反转
     *
     * @param mLinkList 原始单向链表
     * @return 反转后的单向链表
     */
    public static MLinkList reverseRecurse(MLinkList mLinkList) {
        MLinkList reversedMLinkList = mLinkList.clone(); // 存储反转过后的单链表
        if (reversedMLinkList.size() < 2) {
            return mLinkList;
        }
        recurse(reversedMLinkList.getHead().next, reversedMLinkList.getHead());
        return reversedMLinkList;
    }

    /**
     * 反转递归算子，将输入节点及之后的节点反转
     *
     * @param node 输入节点一开始是第一个节点
     * @param head 用于将反转后的首元节点链接到头节点上
     * @return 输出节点与输入节点是同一个，但输出时变成了最后一个节点
     */
    private static Node recurse(Node node, Node head) {
        if (node.next == null) {
            // 递归的出口，直到链表的尾节点终止
            head.next = node;
            return node;
        } else {
            Node cur = recurse(node.next, head);
            Node curPre = node;
            cur.next = curPre;
            return curPre;
        }
    }
}
