package com.xue;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 罗马数字转整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        if(s==null||s.equals("")){
            return -1;
        }
        char []c = s.toCharArray();
            Map<Character,Integer> map = new HashMap<>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);
            int result = 0;
            for(int i=0;i<c.length;){
                if(i+1<c.length&&c[i]=='I'&&c[i+1]=='V'){
                   result = result+4;
                   i = i+2;
                }
                else if(i+1<c.length&&c[i]=='I'&&c[i+1]=='X'){
                    result = result+9;
                    i = i+2;
                }
                else if(i+1<c.length&&c[i]=='X'&&c[i+1]=='L'){
                    result = result+40;
                    i = i+2;
                }
                else if(i+1<c.length&&c[i]=='X'&&c[i+1]=='C'){
                    result+=90;
                    i = i+2;
                }
                else if(i+1<c.length&&c[i]=='C'&&c[i+1]=='D'){
                    result+=400;
                    i = i+2;
                }
                else if(i+1<c.length&&c[i]=='C'&&c[i+1]=='M'){
                    result+=900;
                    i = i+2;
                }else{
                    result = result+map.get(c[i]);
                    i++;
                }
            }
            return result;
        }
    }
