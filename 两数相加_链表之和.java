package com.xue;
import java.util.Scanner;

public class 两数相加_链表之和 {
    static class ListNode{
        int val;
        ListNode next;
    }

    public static void main(String[] args) {
        两数相加_链表之和 ss = new 两数相加_链表之和();
        ListNode root1 = new ListNode();
        root1 = ss.createList(root1);
        ListNode root2 = new ListNode();
        root2 = ss.createList(root2);
       ListNode root3 = ss.addTwoNumbers(root1.next,root2.next);
       print(root3);
    }


    public static void print(ListNode root){
        ListNode h = root;
        while(h!=null){
            System.out.print(h.val+"\t");
            h = h.next;
        }

    }
    public ListNode createList(ListNode root){
        System.out.println("创建几个节点");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println("请依次输入所有节点");
        for(int i=0;i<n;i++){
            ListNode node= new ListNode();
            node.val = sc.nextInt();
            node.next = root.next;
            root.next = node;
        }

        return root;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return null;
        }
        //不再原来的头节点上进行操作，声明两个新开的头节点。
        ListNode p1 = l1;
        ListNode p2 = l2;
        //将链表中的节点转化为数组中的数据，放在数组中，下面是数组进行的下标。
        int m1 = 0;
        int m2 = 0;
        int m3 = 0;
        //将链表中的数据放在数组中。
        int []a =  new int[100];
        int []b = new int[100];
        int []c = new int[100];
        while(p1!=null&&p2!=null){
            a[m1++] = p1.val;
            b[m2++] = p2.val;
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1!=null){
            a[m1++] = p1.val;
            p1 = p1.next;
        }
        while(p2!=null){
            b[m2++] = p2.val;
            p2 = p2.next;
        }
//        for(int i=0;i<m1;i++){
//            System.out.print(a[i]+"\t");
//        }
//        System.out.println();
//        for(int i=0;i<m2;i++){
//            System.out.print(b[i]+"\t");
//        }
//        System.out.println();
        int max = Math.max(m1,m2);
        int e1  = 0;
        int e2 = 0;
        int mid = 0;
        for(int i=0;i<max;i++){

             mid = a[i]+b[i]+e1;
            e1 = mid/10;
            e2 = mid%10;
            c[m3++] = e2;
        }
        if(mid>=10){
            c[m3] = e1;
        }
        for(int i=0;i<=m3;i++){
            System.out.print(c[i]+"\t");
        }
        System.out.println();
        ListNode root3 =  new ListNode();
        ListNode h1 = root3;
        if(c[m3]!=0){
            for(int i=0;i<=m3;i++){
                ListNode node = new ListNode();
                node.val = c[i];
                node.next = null;
                h1.next = node;
                h1 = node;
            }
        }else{
            for(int i=0;i<m3;i++) {
                ListNode node = new ListNode();
                node.val = c[i];
                node.next = null;
                h1.next = node;
                h1 = node;
            }
        }

        return root3.next;
    }
}
