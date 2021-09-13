package com.xue;

import java.util.Scanner;

public class Z字型变换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int numRows =  sc.nextInt();
        System.out.print(convert(s,numRows));
    }
    public static String convert(String s, int numRows) {
        int len = s.length();
        Character [][]c = new Character[numRows][1000];
        int i=0;
        int j = 0;
        int mid = 0;
        while(mid<len){
            for(;i<numRows;i++){
                if(mid>=len){
                    break;
                }
                c[i][j] = s.charAt(mid);
                mid++;
            }
            i = i-2;
            if(i<0){
                i=0;
            }
            j++;
            while(i>0){
                if(mid>=len){
                    break;
                }
                c[i][j] = s.charAt(mid);
                mid++;
                i--;
                j++;
            }
        }
        String result = "";
        for(int k=0;k<numRows;k++){
            for(int k2=0;k2<1000;k2++){
                if(c[k][k2]!=null){
                    result = result+c[k][k2];
                }
            }
        }
        return result;
    }
}
