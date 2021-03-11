package com.lrspace.learn.ds.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: llx
 * Description: 单链表环的相关算法
 * Date: 2021/03/03
 */
public class OpLinkListRing {

    /**
     * 判断链表中是否有环（原理是快慢指针）
     *
     * @param mLinkList 待判断的链表
     * @return 是否有环
     */
    public static boolean existsRing(MLinkList mLinkList) {
        if (mLinkList.getHead().next == null || mLinkList.getHead().next.next == null) {
            return false;
        }
        MNode slow = mLinkList.getHead().next;
        MNode fast = slow;

        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                // 如果出现了尾节点，则不成环
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
    }

    /**
     * 链表中如果有环求环长
     *
     * @param mLinkList
     * @return 环长
     */
    public static int calcRingLength(MLinkList mLinkList) {
        if (mLinkList.getHead().next == null || mLinkList.getHead().next.next == null) {
            return 0;
        }

        MNode slow = mLinkList.getHead().next;
        MNode fast = slow;

        int round = 0; // 记录跑圈数
        int length = 0; // 记录环长度

        while (true) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == null) {
                // 如果出现了尾节点，则没有环
                return 0;
            }

            if (slow == fast) {
                round++;
            }
            if (round == 1) {
                length++;
            }
            if (round == 2) {
                return length;
            }
        }
    }

    /**
     * 如果有环找到环的入口节点
     *
     * @param mLinkList
     * @return 入口节点
     */
    public static MNode findRingDoor(MLinkList mLinkList) {
        if (mLinkList.getHead().next == null || mLinkList.getHead().next.next == null) {
            return null;
        }
        MNode slow = mLinkList.getHead().next;
        MNode fast = slow;

        List<MNode> nodesInRing = new ArrayList<>();

        int round = 0; // 记录跑圈数
        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                // 如果出现了尾节点，则没有环
                return null;
            }
            if (slow == fast) {
                round++;
            }
            if (round == 1) {
                nodesInRing.add(slow);
            }
            if (round == 2) {
                break;
            }
        }
        MNode cur = mLinkList.getHead();
        while (cur.next != null) {
            cur = cur.next;
            if (nodesInRing.contains(cur)) {
                return cur;
            }
        }
        return null;
    }
}
