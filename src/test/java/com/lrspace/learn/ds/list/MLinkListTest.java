package com.lrspace.learn.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MLinkListTest {

    @Test
    public void test() {
        /* 初始化单向链表 */
        MLinkList<String> mLinkList = new MLinkList<>();
        System.out.println("单向链表初始化: " + mLinkList.toString());
        /* 在末尾添加数据元素 */
        mLinkList.add("first");
        System.out.println("在末尾添加数据元素1: " + mLinkList.toString());
        mLinkList.add("third");
        System.out.println("在末尾添加数据元素3: " + mLinkList.toString());
        /* 插入数据元素 */
        mLinkList.insert(1, "second");
        System.out.println("插入数据元素: " + mLinkList.toString());
        /* 删除数据元素 */
        mLinkList.delete(1);
        System.out.println("删除数据元素: " + mLinkList.toString());
        /* 更新数据元素 */
        mLinkList.update(1, "second");
        System.out.println("更新数据元素: " + mLinkList.toString());
        /* 查询数据元素 */
        System.out.println("查询数据元素，位置0: " + mLinkList.select(0));
        System.out.println("查询数据元素，位置1: " + mLinkList.select(1));
    }
}