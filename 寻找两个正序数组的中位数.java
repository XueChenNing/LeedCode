package com.xue;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        寻找两个正序数组的中位数 ss= new 寻找两个正序数组的中位数();
        Scanner sc = new Scanner(System.in);
        int []a ={1,2,3,4,5};
        int []b = {6,7,8,9,10};
        System.out.println(ss.findMedianSortedArrays(a,b));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int []num3 = new int[2000];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                num3[k] = nums1[i];
                k++;
                i++;
            }else{
                num3[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i< nums1.length){
            num3[k] = nums1[i];
            k++;
            i++;
        }
        while(j<nums2.length){
            num3[k] = nums2[j];
            k++;
            j++;
        }
        double mid = 0;
        if(k%2==0){//说明有偶数个
            mid = (num3[k/2]+num3[(k/2)-1])/2.0;
        }else{//合并后数组个数是奇数个
            mid = num3[(k-1)/2];
        }
        BigDecimal b = new BigDecimal(mid);
        return b.setScale(5,BigDecimal.ROUND_HALF_UP).doubleValue();

    }
}
