package com.lrspace.learn.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MLinkStackTest {

    @Test
    public void testStack() {
        MLinkStack<Integer> mLinkStack = new MLinkStack();
        mLinkStack.push(1);
        System.out.println("入栈操作：" + mLinkStack.toString());
        mLinkStack.push(2);
        System.out.println("入栈操作：" + mLinkStack.toString());
        mLinkStack.push(3);
        System.out.println("入栈操作：" + mLinkStack.toString());
        mLinkStack.push(4);
        System.out.println("入栈操作：" + mLinkStack.toString());
        mLinkStack.push(5);
        System.out.println("入栈操作：" + mLinkStack.toString());
        mLinkStack.push(6);
        System.out.println("入栈操作：" + mLinkStack.toString());

        System.out.println("出栈操作：" + mLinkStack.pop().toString() + "，" + mLinkStack.toString());
        System.out.println("出栈操作：" + mLinkStack.pop().toString() + "，" + mLinkStack.toString());
        System.out.println("出栈操作：" + mLinkStack.pop().toString() + "，" + mLinkStack.toString());
        System.out.println("出栈操作：" + mLinkStack.pop().toString() + "，" + mLinkStack.toString());
        System.out.println("出栈操作：" + mLinkStack.pop().toString() + "，" + mLinkStack.toString());
        System.out.println("出栈操作：" + mLinkStack.pop().toString() + "，" + mLinkStack.toString());
    }
}