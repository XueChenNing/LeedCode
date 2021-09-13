package com.xue;

public class 正则表达式匹配 {
    public static void main(String[] args) {
        System.out.println(isMatch("mississippi","mis*is*ip*."));
    }
    public static boolean isMatch(String s, String p) {
        if(s==null&&p==null){
            return true;
        }
        if(s==null||p==null){
            return false;
        }
        if(s.equals(p)){
            return true;
        }
        int k1=0;
        int k2=0;
        char []c1 = s.toCharArray();
        char []c2 = p.toCharArray();
        while(k1<s.length()&&k2<p.length()){
            if(c1[k1]==c2[k2]){
                k1++;
                k2++;
                continue;
            }
            if(c2[k2]=='.'){
                k1++;
                k2++;
                continue;
            }
            if(c2[k2]=='*'){
                if(c1[k1]==c2[k2-1]){
                    k1++;
                }
                else if(c2[k2-1]=='.'){
                    k1++;
                }
                else if(((k2+1<p.length())&&(c2[k2+1]==c1[k1]))||c2[k2+1]=='.'){
                    k1++;
                    k2 = k2+2;
                }else{
                    return false;
                }
            }

            if((k2+1<p.length())&&c2[k2+1]=='*'&&c1[k1]!=c2[k2]){
                k2 = k2+2;
            }

        }
        if(c2[p.length()-1]=='*'){
            k2+=1;
        }
        if(k1==s.length()&&k2==p.length()){
            return true;
        }else{
            return false;
        }
    }
}
