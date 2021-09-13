package com.xue;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==0||nums.length==1){
            return null;
        }
        int i=0;
        int []result ;
        for(int j=0;j<nums.length;j++){
            for(int j2=j+1;j2<nums.length;j2++){
                if(nums[j]+nums[j2]==target){
                    result = new int[2];
                    result[0] = j;
                    result[1] = j2;
                    return result;
                }
            }
        }
        return null;

    }
}
