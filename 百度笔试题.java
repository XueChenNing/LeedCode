package com.xue;

import java.util.HashMap;
import java.util.Map;

public class 百度笔试题 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(getResult("eecbad",5));
    }
    public static long getResult(String s,int k){
        long ans = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                String s1 = s.substring(i,j);
                System.out.println(s1);
                Map<Character,Integer> map = new HashMap<>();
                for(int m=0;m<s1.length();m++){
                    map.put(s1.charAt(m),1);
                }
                if(map.size()==k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
