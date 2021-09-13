package com.xue.tree;

import java.util.Stack;

/**
 * 问题描述：给定一个二叉树，求出这个二叉树中最大子树节点和。
 * 问题分析：要求出一颗二叉树的最大子树的和，最容易想到的方法就是  针对每颗子树，求出所有子树的和，然后找出所有子树的最大值即可
 * 但是这样做的时间复杂度太高了。
 * 恰好二叉树的后序遍历就能够做到这一点，如果当前遍历节点的值与其左右子节点相加的和大于最大值，那么就可以更新最大值，然后一直递归遍历即可。
 */
public class 求一个二叉树的最大子树和 {
    private static int maxSum = Integer.MIN_VALUE;
    static class Node{
        int data;
        Node lchild;
        Node rchild;
    }

    public static int findMaxSubTree(Node root,Node maxTree){
        if(root==null){
            return 0;
        }
        int lMax = findMaxSubTree(root.lchild,maxTree);
        int rMax = findMaxSubTree(root.rchild,maxTree);
        int sum = lMax+rMax+root.data;
        if(sum>maxSum){
            maxSum = sum;
            maxTree.data = root.data;
        }

        return sum;
    }

    public static Node createTree(){//直接创建二叉树，并没有使用递归的方式创建二叉树
        /**二叉树结构
                6

            3      -7

         -1   9


         */
        Node root = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        root.data = 6;
        node1.data = 3;
        node2.data = -7;
        node3.data = -1;
        node4.data = 9;
        root.lchild = node1;
        root.rchild = node2;
        node1.lchild = node3;
        node1.rchild = node4;
        node2.lchild = node2.rchild = node3.lchild = node3.rchild = node4.lchild = node4.rchild = null;

        return root;


    }

    public static void main(String[] args) {
        求一个二叉树的最大子树和 搜时= new 求一个二叉树的最大子树和();
        Node root = createTree();
        Node maxTree = new Node();
        findMaxSubTree(root,maxTree);
        System.out.println("最大子树和为"+maxSum);
        System.out.println("最大子树的根节点为"+maxTree.data);

    }
}
