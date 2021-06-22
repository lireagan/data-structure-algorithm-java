package com.lrspace.learn.ds.tree;

/**
 * Author: llx
 * Description: 二叉树节点
 * Date: 2021/03/14
 */
public class MBiTreeNode<E> {
    // 数据元素
    private E data;
    // 左子节点
    private MBiTreeNode leftChild;
    // 右子节点
    private MBiTreeNode rightChild;

    public MBiTreeNode(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public MBiTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MBiTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public MBiTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(MBiTreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
