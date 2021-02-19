package com.lrspace.learn.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MLinkListAdvancedOpTest {

    @Test
    public void reverse() {
        /* 初始化 */
        MLinkList<Integer> mLinkList = new MLinkList<>();
        mLinkList.add(1);
        mLinkList.add(2);
        mLinkList.add(3);
        mLinkList.add(4);
        mLinkList.add(5);
        System.out.println("原始单向链表: " + mLinkList.toString());
        /* 循环遍历反转 */
        MLinkList reverseLoop = MLinkListAdvancedOp.reverseLoop(mLinkList);
        System.out.println("【方法一】循环遍历反转: " + reverseLoop.toString());
        /* 递归反转 */
        MLinkList reverseRecurse = MLinkListAdvancedOp.reverseRecurse(mLinkList);
        System.out.println("【方法二】递归反转: " + reverseRecurse.toString());
    }
}