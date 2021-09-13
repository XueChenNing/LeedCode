package com.xue;

public class 携程第三题笔试题 {
    public static void main(String[] args) {
        for(int i:map.keySet){
            a[k++]=i;
        }
        for(int i:findMountain(new int[]{500,300,800,300,270,570}))
       System.out.println(i);
    }
    public static int[] findMountain(int[] height){
        int[][] map=new int[height.length][3];
        for(int i=0;i<height.length;i++){
            int sum=1;
            for(int j=i+1;j<height.length;j++){
                if(height[j]>height[i]){
                    sum++;
                }else {
                    sum++;
                    break;
                }
            }
            for(int k=i-1;k>=0;k--){
                if(height[k]>height[i]){
                    sum++;
                }else {
                    sum++;
                    break;
                }
            }
            map[i][0]=sum;
        }
        int[] ans=new int[height.length];
        for(int i=0;i<height.length;i++){
            ans[i]=map[i][0];
        }
        return ans;
    }
}
