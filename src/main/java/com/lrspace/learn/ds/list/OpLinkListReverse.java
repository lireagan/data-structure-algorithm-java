package com.lrspace.learn.ds.list;


/**
 * Author: llx
 * Description: 单链表反转
 * Date: 2021/2/17
 */
public class OpLinkListReverse {

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
        MNode curPre = reversedMLinkList.getHead().next;
        MNode cur = curPre.next;
        curPre.next = null; // 首元节点变成尾节点，指向null

        while (cur.next != null) {
            MNode curNext = cur.next;
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
        // TODO 有bug
        MLinkList reversedMLinkList = mLinkList.clone(); // 存储反转过后的单链表
        if (reversedMLinkList.size() < 2) {
            return mLinkList;
        }
        recurse(reversedMLinkList.getHead().next, reversedMLinkList.getHead());
        return reversedMLinkList;
    }

    /**
     * 反转递归算子：recurse(MLinkList)= recurse(MLinkList.next) + 然后把反转尾节点指向首元节点
     *
     * @param firstNode 首元节点
     * @param head      头结点
     * @return 反转之后的尾节点
     */
    private static MNode recurse(MNode firstNode, MNode head) {
        if (firstNode.next == null) {
            // 递归的出口，直到链表的尾节点终止
            head.next = firstNode;
        } else {
            MNode lastNodeAfterReverse = recurse(firstNode.next, head);
            firstNode.next = null;
            lastNodeAfterReverse.next = firstNode;
        }
        return firstNode;
    }
}
