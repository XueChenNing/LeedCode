package com.xue;

import java.util.HashMap;
import java.util.Map;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        int []a = {2,2,1};
        System.out.println(singleNumber(a));
    }
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map =  new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
                continue;
            }
            map.put(nums[i],nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}
