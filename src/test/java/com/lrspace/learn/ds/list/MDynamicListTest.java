package com.lrspace.learn.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MDynamicListTest {

    @Test
    public void size() {
        /* 顺序表初始化 */
        MDynamicList mDynamicList = new MDynamicList<String>();
        System.out.println("顺序表初始化: " + mDynamicList.toString());
        /* 在末尾添加数据元素 */
        mDynamicList.add("first");
        System.out.println("在末尾添加数据元素1: " + mDynamicList.toString());
        mDynamicList.add("third");
        System.out.println("在末尾添加数据元素3: " + mDynamicList.toString());
        /* 插入数据元素 */
        mDynamicList.insert(1, "second");
        System.out.println("插入数据元素: " + mDynamicList.toString());
        /* 删除数据元素 */
        mDynamicList.delete(1);
        System.out.println("删除数据元素: " + mDynamicList.toString());
        /* 更新数据元素 */
        mDynamicList.update(1, "second");
        System.out.println("更新数据元素: " + mDynamicList.toString());
        /* 查询数据元素 */
        System.out.println("查询数据元素，位置0: " + mDynamicList.select(0));
        System.out.println("查询数据元素，位置1: " + mDynamicList.select(1));
    }
}