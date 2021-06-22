package com.lrspace.learn.ds.tree;

/**
 * Author: llx
 * Description: 二叉树
 * Date: 2021/03/14
 */
public class MBiTree<E> {
    // 根节点
    public MBiTreeNode<E> root;

    /**
     * 通过顺序数组初始化链表二叉树
     *
     * @param data 二叉树的数组形式
     */
    public MBiTree(E[] data) {
        if (data.length == 0) {
            this.root = null;
        }
        this.root = create(data);
    }

    /**
     * 通过一个数组二叉树创建一个链表二叉树（递归实现）
     *
     * @param data 数组二叉树
     * @return 链表二叉树的根节点
     */
    private MBiTreeNode create(E[] data) {
        if(data == null) {
            return null;
        }
        MBiTreeNode root = new MBiTreeNode(null);
        root.setData(data[0]);
        root.setLeftChild(create(subArray(data,1)));
        root.setLeftChild(create(subArray(data,2)));
        return root;
    }

    /**
     * 从指定位置截断余下的数组
     * @param data 原始数组
     * @param begin 截断的开始位置
     * @return 截断后的数组
     */
    private E[] subArray(E[] data, int begin) {
        if (begin > data.length - 1) {
            return null;
        }
        E[] sub = (E[]) new Object[data.length - begin];
        int j=0;
        for (int i = begin; i < data.length; i++) {
            sub[j] = data[i];
            j++;
        }
        return sub;
    }

    /**
     * 先序遍历
     *
     * @param node
     */
    public void preOrderTraverse(MBiTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        preOrderTraverse(node.getLeftChild());
        preOrderTraverse(node.getRightChild());
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrderTraverse(MBiTreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.getLeftChild());
        System.out.println(node.getData());
        inOrderTraverse(node.getLeftChild());
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrderTraverse(MBiTreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.getLeftChild());
        postOrderTraverse(node.getLeftChild());
        System.out.println(node.getData());
    }

}
