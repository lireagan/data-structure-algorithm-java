package com.lrspace.learn.ds.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MBiTreeTest {
    MBiTree<Integer> mBiTree;

    @Before
    public void create() {
        Integer[] data = new Integer[]{1,2,null,3,4,null,null,5,null,null,null,null,null,null,null};
        mBiTree = new MBiTree(data);
    }

    @Test
    public void traverse() {
        System.out.println("前序遍历：");
        mBiTree.preOrderTraverse(mBiTree.root);
        System.out.println("中序遍历：");
        mBiTree.inOrderTraverse(mBiTree.root);
        System.out.println("后序遍历：");
        mBiTree.postOrderTraverse(mBiTree.root);
    }
}