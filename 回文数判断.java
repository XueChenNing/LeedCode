package com.xue;

public class 回文数判断 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
    public static boolean isPalindrome(int x) {
        int []a = new int[100];
        int k=0;
        boolean flag =  true;
        if(x<0){
            return false;
        }
        while(x>0){
            a[k++] = x%10;
            x = x/10;
        }
        for(int i=0;i<k;i++){
            if(a[i]!=a[k-1-i]){
                flag = false;
            }
        }
        return flag;
    }
}
