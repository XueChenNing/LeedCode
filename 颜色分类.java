package com.xue;

public class 颜色分类 {
    public void sortColors(int[] nums) {
        for(int i=0;i< nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = 0;
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
        System.out.println();
    }
}
