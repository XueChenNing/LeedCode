package com.xue;

import java.util.Scanner;

public class 字符串转换整数 {
    public static void main(String[] args) {
        String s ="-2147483648";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        if(s.equals("")){
            return 0;
        }
        Character []characters = new Character[200];
        int v=0;
        while(s.charAt(v)==' '){
            v++;
            if(v==s.length()){
                return 0;
            }
        }
        if((s.charAt(v)!='-'&&s.charAt(v)!='+')&&(s.charAt(v)<'0'||s.charAt(v)>'9')){
            return 0;
        }
        if(s.charAt(v)>='0'&&s.charAt(v)<='9'){
            int []a = new int[200];
            int b1 = 0;
            for(int i=v;i<s.length();i++){
                if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                    break;
                }
               a[b1++] = s.charAt(i)-'0';
            }
              double result =  0;
            for(int i=0;i<b1;i++){
                result = result+a[i]*Math.pow(10,b1-i-1);
            }
            double l = Math.pow(2,31)-1;
            if(result>l){
                return (int)l;
            }
            return (int)result;
//            for(int i=0;i<b1;i++){
//                System.out.print(a[i]+"\t");
//            }
//            System.out.println();
        }
        if(s.charAt(v)=='-'||s.charAt(v)=='+'){
            int []a2 = new int[200];
            int b2 = 0;
            for(int i=v+1;i<s.length();i++){
                if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                    break;
                }
                a2[b2++] = s.charAt(i)-'0';
            }

            double result =  0;
            for(int i=0;i<b2;i++){
                result = result+a2[i]*Math.pow(10,b2-i-1);
//                result=result*10+a2[i];
            }
            double r = Math.pow(2,31)-1;
            double l = Math.pow(2,31);
            if(s.charAt(v)=='-'){
                if(result>=l){
                    return (int)(l*(-1));
                }else{
                  return (int)result*(-1);
                }
            }
            if(s.charAt(v)=='+'){
                if(result>=r){
                    return (int)r;
                }else{
                    return (int)result;
                }
            }
//            for(int i=0;i<b2;i++){
//                System.out.print(a2[i]+"\t");
//            }
//            System.out.println();
        }
        return 0;
    }
}
