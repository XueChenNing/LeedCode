package com.xue;

import java.util.Scanner;

public class 反转整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(reverse(x));
    }
    public static int reverse(int x) {
        if(x==0){
            return 0;
        }
        double std = Math.pow(2,31);
        int []a = new int[100];
        int begin = 0;
        int x1 = x;
        if(x1<0){
            x1 = x1* (-1);
        }
        while(x1>0){
            int mid = x1%10;
            a[begin++] = mid;
            x1 = x1/10;
        }

        double result = 0;
       for(int i=0;i<begin;i++){
           System.out.print(a[i]+"\t");
           result = result+a[i]*Math.pow(10,begin-i-1);
       }
       System.out.println();

       if(result>std){
           return 0;
       }
       if(x<0){
           return ((int)result)*(-1);
       }
       return (int)result;
    }
}
