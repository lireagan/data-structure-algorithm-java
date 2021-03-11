package com.lrspace.learn.ds.list;


/**
 * Author: llx
 * Description: 单链表相交判断
 * Date: 2021/03/03
 */
public class OpLinkListIntersect {
    /**
     * 判断链表是否相交（O(n+m)），原理是2个相交的链表末尾肯定一样
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 是否相交
     */
    public static boolean judgeIntersectByLast(MLinkList l1, MLinkList l2) {
        MNode cur1 = l1.getHead().next;
        MNode cur2 = l2.getHead().next;

        while (cur1.next != null) {
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
        }

        return cur1 == cur2;
    }
}
