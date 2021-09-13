package com.xue.tree;

/**
 * 不使用数据结构或者说要求空间复杂度O（1）来实现二叉树的层序遍历
 */
public class 层序遍历2 {
    static class Node {
        int data;
        Node lchild;
        Node rchild;
    }
    public Node createTree(int []a,int start,int end){
        Node root = null;
        if(start<=end){
            root = new Node();
            int mid = (start+end)/2;
            root.data = a[mid];
            root.lchild = createTree(a,start,mid-1);
            root.rchild = createTree(a,mid+1,end);
        }
        return root;
    }

    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.lchild);
            System.out.print(root.data+"\t");
            inOrder(root.rchild);
        }
    }

    //求出二叉树的最大深度
    public int depth(Node root){
        if(root==null){
            return 0;
        }
        int ldepth = depth(root.lchild);
        int rdepth = depth(root.rchild);
        return Math.max(ldepth,rdepth)+1;
    }

    //分层打印二叉树
    public void printByLevel(Node root){
        int level = depth(root);
        for(int i=0;i<level;i++){
            printAtLevel(root,i);
        }
    }

    public void printAtLevel(Node root,int level){
        if(root==null||level<0){
            return;
        }
        else if(level==0){
            System.out.print(root.data+"\t");
        }
        else{
            printAtLevel(root.lchild,level-1);
            printAtLevel(root.rchild,level-1);
        }
    }

    public static void main(String[] args) {
        层序遍历2 ss = new 层序遍历2();
        int []a = {1,2,3,4,5,6,7,8,9,10};
        Node root = null;
        root = ss.createTree(a,0,a.length-1);
        ss.inOrder(root);
        System.out.println();
        System.out.println("下面是递归层序遍历");
        ss.printByLevel(root);
    }
}
