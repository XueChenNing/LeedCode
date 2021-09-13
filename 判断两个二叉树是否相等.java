package com.xue.tree;

/**
 * 问题描述：给定两个二叉树，判断两个二叉树是否相等
 * 分析：要判断两个二叉树是否相等首先是从根节点开始的，主要有两步：
 * 1。根节点的值是否相等，如果相等递归遍历（第一个树当前节点的左子树==第二棵树当前节点的左子树）&&（第一棵树当前节点的右子树==第二棵树当前节点的右子树）
 */
public class 判断两个二叉树是否相等 {
    static class Node {
        int data;
       Node lChild;
       Node rChild;
    }

    public Node createTree(int []a, int start, int end){
        Node root = null;
        if(start<=end){//设定一个递归退出的条件
            root = new Node();
            int mid = (start+end)/2;//取数组中间的元素，因为有序二叉树就是   左节点最小，根节点次之，右节点最大
            root.data = a[mid];
            root.lChild = createTree(a,start,mid-1);
            root.rChild = createTree(a,mid+1,end);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root!=null){
            inOrder(root.lChild);
            System.out.print(root.data+"\t");
            inOrder(root.rChild);
        }
    }

    public static boolean getEqual(Node root1,Node root2){
        if(root1==null&&root2==null){//两个二叉树都是空树
            return true;
        }
        if(root1==null||root2==null){//两个二叉树其中一个是空树
            return false;
        }
        if(root1.data==root2.data){//两个二叉树都不是空树，并且跟节点的值相等
            return getEqual(root1.lChild,root2.lChild)&&getEqual(root1.rChild,root2.rChild);
        }else{
            return false;//当前节点的值不相等
        }
    }

    public static void main(String[] args) {
        Node root1 = null;
        Node root2 = null;
        int []a = {1,2,3,4,5,6,7,8,9,10};
        int []b = {1,2,3,4,5,6,7,8,9};
        判断两个二叉树是否相等 createBinaryTree = new 判断两个二叉树是否相等();
        root1 = createBinaryTree.createTree(a,0,a.length-1);
        root2 = createBinaryTree.createTree(b,0,b.length-1);
        if(getEqual(root1,root2)){
            System.out.println("两个二叉树相等");
        }else{
            System.out.println("两个二叉树不相等");
        }
    }
}
