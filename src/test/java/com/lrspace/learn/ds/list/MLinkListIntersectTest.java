package com.lrspace.learn.ds.list;

import org.junit.Test;

public class MLinkListIntersectTest {

    @Test
    public void judgeIntersectByLast() {
        MLinkList<String> l1 = new MLinkList<>();
        MLinkList<String> l2 = new MLinkList<>();
        MLinkList<String> l3 = new MLinkList<>();


        l1.add("node1");
        l1.add("node2");
        l1.add("node3");
        l1.add("node4");
        l1.add("node5");
        Node cur1 = l1.getHead().next;
        for(int i=0;i<3;i++) {
            cur1 = cur1.next;
        }
        System.out.println("l1：" +l1.toString());

        l2.add("node6");
        l2.add("node7");
        Node cur2 = l2.getHead().next;
        while(cur2.next != null) {
            cur2 = cur2.next;
        }
        cur2.next = cur1;
        System.out.println("l2：" +l2.toString());

        l3.add("node8");
        l3.add("node9");
        System.out.println("l3：" +l3.toString());

        System.out.println("l1与l2是否相交：" + MLinkListIntersect.judgeIntersectByLast(l1, l2));
        System.out.println("l2与l3是否相交：" + MLinkListIntersect.judgeIntersectByLast(l2, l3));
        System.out.println("l3与l1是否相交：" + MLinkListIntersect.judgeIntersectByLast(l3, l1));

    }
}