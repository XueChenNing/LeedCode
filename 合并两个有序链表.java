package com.xue;

import java.util.Scanner;

public class 合并两个有序链表 {
    static class ListNode{
        int val;
        ListNode next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 =  l1;
        ListNode p2 = l2;
        ListNode head = null;
        if(l1==null&&l2==null){
            return null;
        }
        head = new ListNode();
        ListNode head2 = head;
        while(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                ListNode node =  new ListNode();
                node.next = null;
                node.val = p1.val;
                head2.next = node;
                head2 = head2.next;
                p1 = p1.next;
            }else{
                ListNode node = new ListNode();
                node.next = null;
                node.val = p2.val;
                head2.next = node;
                head2 = head2.next;
                p2 = p2.next;
            }
        }
        while(p1!=null){
            ListNode node =  new ListNode();
            node.next = null;
            node.val = p1.val;
            head2.next = node;
            head2 = head2.next;
            p1 = p1.next;
        }
        while(p2!=null){
            ListNode node = new ListNode();
            node.next = null;
            node.val = p2.val;
            head2.next = node;
            head2 = head2.next;
            p2 = p2.next;
        }
        return head.next;
    }
}
