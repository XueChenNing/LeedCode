package com.xue;

/**
 * 典型的快慢指针问题
 */
public class 判断链表是否有环 {
    static class ListNode{
        int val;
        ListNode next;
    }

    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        if(head.next==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&slow!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

}
