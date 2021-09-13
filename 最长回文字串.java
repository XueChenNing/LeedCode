package com.xue;

import java.util.Scanner;

public class 最长回文字串 {
    public static void main(String[] args) {
        最长回文字串 ss = new 最长回文字串();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(ss.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int begin=0;
        int maxlen = 1;
        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char chars[] = s.toCharArray();
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if(chars[i]!=chars[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }


                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxlen){
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }

        // 4. 返回值
        return s.substring(begin,begin + maxlen);
    }
}
