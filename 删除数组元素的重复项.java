package com.xue;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 删除数组元素的重复项 {
    public static void main(String[] args) {
        int []a = {1,1,2,3,4,4};
        removeDuplicates(a);
    }
    public static int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int k=1;
        for(int i=0;i< nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            nums[k++] = nums[i+1];
        }
        for(int i=k;i<nums.length;i++){
            nums[i] =  0;
        }
        return k;
    }
}

