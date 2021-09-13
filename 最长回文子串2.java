package com.xue;


import java.util.Scanner;

public class 最长回文子串2 {
    public static void main(String[] args) {
        最长回文子串2 ss = new 最长回文子串2();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(ss.longestPalindrome(s));
    }

    private String longestPalindrome(String s) {
        int len = s.length();
        if(len==1){
            return s;
        }
        char []c = s.toCharArray();
        int begin = 0;
        int maxlen = 1;
        boolean [][]dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if(c[i]!=c[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]==true&&j-i+1>maxlen){
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
}
