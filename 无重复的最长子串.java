package com.xue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class 无重复的最长子串 {
    public static void main(String[] args) {
        无重复的最长子串 ss = new 无重复的最长子串();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ss.lengthOfLongestSubstring(s);
       System.out.println(ss.lengthOfLongestSubstring(s)) ;
    }
    public int lengthOfLongestSubstring(String s) {
        //用来存放最长不重复子串
        HashMap<String,Integer> hashMap = new LinkedHashMap();
        //每次hashMap的长度
        int len = 0;
        //用来标记下一次回溯到那一个位置；
        int mark = 0;
        for(int i=0;i<s.length();){
            if(!hashMap.containsKey(s.charAt(i)+"")){
              hashMap.put(s.charAt(i)+"",mark);
              mark++;
              i++;
            }else{
                if(hashMap.size()>len){
                    len = hashMap.size();
                }
                mark = hashMap.get(s.charAt(i)+"")+1;
                i = hashMap.get(s.charAt(i)+"")+1;

                hashMap.clear();
            }
        }

        if(hashMap.size()>len){
            len = hashMap.size();
        }
        return len;
    }
}
