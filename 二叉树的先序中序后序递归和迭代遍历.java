package com.xue;

import sun.awt.image.ImageWatched;

import java.util.*;

public class 二叉树的先序中序后序递归和迭代遍历 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val = 2;
        TreeNode node3 = new TreeNode();
        node3.val = 3;
        root.left = node2;
        root.right = node3;
        TreeNode node4 = new TreeNode();
        node4.val = 4;
        TreeNode node5 = new TreeNode();
        node5.val = 5;
        node2.left = node4;
       node2.right = node5;

        TreeNode node6 = new TreeNode();
        node6.val = 6;
        TreeNode node7 = new TreeNode();
        node7.val = 7;
        node3.left = node6;
        node3.right = node7;
     levelOrder(root);
    }

    /**
     * 递归先序遍历
     * @param root
     */
    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序递归遍历
     * @param node
     */
    public static void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.val+"\t");
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历递归
     * @param node
     */
    public static void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val+"\t");
        }
    }

    /**
     * 层序遍历迭代
     * @param root
     */
    public static void preOrder2(TreeNode root){
        if(root==null){
            System.out.println("树是一个空树");
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+"\t");
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历非迭代
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<Integer>();
        if(root==null){
            return  null;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp =stack.pop();
            list.add(0,temp.val);
            System.out.print(temp.val+"\t");
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
        return list;
    }



    /**
     * 基于栈的中序遍历，也就是非递归写法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(stack.size()>0 || root!=null) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if(root!=null) {
                stack.add(root);
                root = root.left;
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }


    /**
     * 迭代实现层序遍历,但是这个格式不太一样，每一层需要额外分开
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return null;
        }
        List<List<Integer>>list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            List<Integer> list1 = new LinkedList<>();
            count = queue.size();
            while(count>0){
                TreeNode node = queue.poll();
                list1.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                count--;
            }
            list.add(list1);
        }
        return list;
    }

}
