package com.xue.stack;

import java.util.Stack;

/**
 * 要求时间复杂度为O（1），所以说一定不能遍历栈中所有的元素，一般要求时间复杂度的我们就使用空间换时间来实现
 * 在本题中我们使用一个新的数据结构来保存元素栈最小的元素
 */
public class 找出栈中最小的元素 {
    static class MyStack{
        //用来保存元素的栈
        Stack<Integer> elemStack = new Stack<>();
        //用来保存elemStack中始终最小的元素
        Stack<Integer> minStack = new Stack<>();

        //模拟入栈过程，同时将每一次进入元素栈的元素做一个判断，如果比之前所有元素栈的元素都小，那说明当前入栈是最小的，所以放入到minStack中
        public void push(int a){
            elemStack.push(a);
            if(minStack.isEmpty()){
                minStack.push(a);
            }else{
                if(a<minStack.peek()){
                    minStack.push(a);
                }
            }
        }

        //下面求出最小值
        public int min(){
            if(minStack.isEmpty()){//栈中不存在元素
                return -1;
            }else{
                //存在元素，那么栈顶的那个元素一定是元素栈所有元素中最小的那个。
                return minStack.peek();
            }
        }

        //下面模拟出栈过程
        public void pop(){
            if(elemStack.isEmpty()){
                System.out.println("当前栈为空");
            }else{
              int temp =  elemStack.pop();
              if(temp==minStack.peek()){
                  minStack.pop();
              }
            }
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(2);
        System.out.println(myStack.min());
        myStack.push(3);
        System.out.println(myStack.min());
        myStack.push(1);
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());
    }
}
