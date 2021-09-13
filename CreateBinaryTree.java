package com.xue.tree;

/**
 * 根据一个有序数组来构建一个有序二叉树
 * 其实就是先序创建二叉树，无非就是节点数据我们需要根据遍历时候的数据来填充
 */
public class CreateBinaryTree {
   static class Node {
        int data;
        Node lChild;
        Node rChild;
    }

    public Node createTree(int []a,int start,int end){
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

    public static void main(String[] args) {
       Node root = null;
        int []a = {1,2,3,4,5,6,7,8,9,10};
        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        root = createBinaryTree.createTree(a,0,a.length-1);
        inOrder(root);
    }
}
