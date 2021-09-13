package com.xue.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * Question Description:给定一个数组，找出数组中是否存在两个数对（a,b） (c,d)使得  a+b==c+d
 * 其中a,b,c,d是不同的元素，如果结果有多个，那个打印一组就行。
 */
public class 找出两个相等的数对问题 {

    //每一个节点代表HashMap中的值，也就是一个数对
    static class Node{
        //数对的第一和第二个索引
        int first;
        int second;
        Node(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public void getElem(int []a){
        Map<Integer,Node> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                int key = i+j;
                if(!map.containsKey(key)){
                    map.put(key,new Node(i,j));
                }else{
                    Node result = new Node(i,j);
                    Node result2 = map.get(i+j);
                    System.out.println("("+a[result.first]+","+a[result.second]+")"+"      "+"("+a[result2.first]+","+a[result2.second]+")");
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {

        int []a = {1,2,3,4,5,6};
        找出两个相等的数对问题 ss = new 找出两个相等的数对问题();
        ss.getElem(a);
    }
}
