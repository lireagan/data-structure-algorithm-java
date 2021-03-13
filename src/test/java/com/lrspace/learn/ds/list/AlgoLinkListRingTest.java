package com.lrspace.learn.ds.list;

import org.junit.Test;

public class AlgoLinkListRingTest {

    @Test
    public void testRing() {

        MNode n1 = new MNode(1);
        MNode n2 = new MNode(2);
        MNode n3 = new MNode(3);
        MNode n4 = new MNode(4);
        MNode n5 = new MNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;



        MLinkList<Integer> mLinkList = new MLinkList<>();
        MNode head = mLinkList.getHead();
        head.next = n1;

        System.out.println("该链表中是否有环：" + AlgoLinkListRing.existsRing(mLinkList));
        System.out.println("环的长度是：" + AlgoLinkListRing.calcRingLength(mLinkList));
        System.out.println("环的入口节点的数据域是：" + AlgoLinkListRing.findRingDoor(mLinkList).data);
        System.out.println("该链表的长度是：" + mLinkList.size());
    }
}