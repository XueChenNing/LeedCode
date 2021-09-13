package com.xue;

public class 删除链表的倒数第N个节点 {
    static class ListNode{
        int val;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        node1.next = node2;

        ListNode node3 = new ListNode();
        node3.val = 3;
        node2.next = node3;

        ListNode node4 = new ListNode();
        node4.val = 4;
        node3.next = node4;

        ListNode node5 = new ListNode();
        node5.val = 5;
        node4.next = node5;
        removeNthFromEnd(node1,2);
    }
    public  static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return null;
        }
        int k=0;
        int k1=0;
        ListNode node1 = head;
        ListNode node2 = head;
        ListNode node3 = head;
        ListNode node4 = head;
//        System.out.println(node1.val);
//        while(node3!=null){
//            System.out.print(node3.val+"\t");
//            node3 = node3.next;
//        }
//        System.out.println();
//        System.out.println(k);
        while(node4!=null){
            k1++;
            node4 = node4.next;
        }
        if(k1==n){
            return head.next;
        }
        else {
            while(k<n+1){
                node2 = node2.next;
                k++;
            }
            while(node1!=null&&node2!=null){
                k++;
                node1 = node1.next;
                node2 = node2.next;
            }
            node1.next = node1.next.next;
//                    while(node3!=null){
//            System.out.print(node3.val+"\t");
//            node3 = node3.next;
//        }
            return head;
        }
    }
}
