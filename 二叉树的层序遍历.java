package com.xue.tree;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的层序遍历 {
    static class Node {
        int data;
        Node lChild;
        Node rChild;
    }

    //创建二叉树
    public Node createTree(int []a, int start, int end){
        Node root = null;
        if(start<=end){//设定一个递归退出的条件
            root = new Node();
            int mid = (start+end+1)/2;//取数组中间的元素，因为有序二叉树就是   左节点最小，根节点次之，右节点最大
            root.data = a[mid];
            root.lChild = createTree(a,start,mid-1);
            root.rChild = createTree(a,mid+1,end);
        }
        return root;
    }
    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.lChild);
            System.out.print(root.data+"\t");
            inOrder(root.rChild);
        }
    }

    public void levelOrder(Node root){
        Queue<Node> list = new LinkedList();
        list.offer(root);
        while(!list.isEmpty()){
           Node node = list.poll();
           System.out.print(node.data+"\t");
           if(node.lChild!=null){
               list.add(node.lChild);
           }
           if(node.rChild!=null){
               list.add(node.rChild);
           }
        }
    }

    public static void main(String[] args) {
        Node root = null;
        二叉树的层序遍历 aa = new 二叉树的层序遍历();
        int []a = {1,2,3,4,5,6,7,8,9,10};
        root = aa.createTree(a,0,a.length-1);
        System.out.println("下面是中序遍历");
        aa.inOrder(root);
        System.out.println();
        System.out.println("下面是层序遍历");
        aa.levelOrder(root);
    }
}
