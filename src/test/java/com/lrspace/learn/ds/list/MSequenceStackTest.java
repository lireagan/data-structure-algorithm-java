package com.lrspace.learn.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MSequenceStackTest {

    @Test
    public void testStack() {
        MSequenceStack<Integer> mSequenceStack = new MSequenceStack(10);
        mSequenceStack.push(1);
        System.out.println("入栈操作：" + mSequenceStack.toString());
        mSequenceStack.push(2);
        System.out.println("入栈操作：" + mSequenceStack.toString());
        mSequenceStack.push(3);
        System.out.println("入栈操作：" + mSequenceStack.toString());
        mSequenceStack.push(4);
        System.out.println("入栈操作：" + mSequenceStack.toString());
        mSequenceStack.push(5);
        System.out.println("入栈操作：" + mSequenceStack.toString());
        mSequenceStack.push(6);
        System.out.println("入栈操作：" + mSequenceStack.toString());

        System.out.println("出栈操作：" + mSequenceStack.pop().toString() + "，" + mSequenceStack.toString());
        System.out.println("出栈操作：" + mSequenceStack.pop().toString() + "，" + mSequenceStack.toString());
        System.out.println("出栈操作：" + mSequenceStack.pop().toString() + "，" + mSequenceStack.toString());
        System.out.println("出栈操作：" + mSequenceStack.pop().toString() + "，" + mSequenceStack.toString());
        System.out.println("出栈操作：" + mSequenceStack.pop().toString() + "，" + mSequenceStack.toString());
        System.out.println("出栈操作：" + mSequenceStack.pop().toString() + "，" + mSequenceStack.toString());

    }
}