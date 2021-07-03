package com.leetcode.arr;

public class ThreeSort {

    public static void main(String[] args) {
        int arr[]=new int[]{0,1,1,0,2,2,0,1};
        int one=-1,two=arr.length;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==0){
                one++;
                swap(arr,one,i);
            }
            if (arr[i]==1){

            }
            if (arr[i]==2){
                two--;
                swap(arr,two,i);
            }
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }

    private static void swap(int[] arr,int i,int k){
        Integer a=arr[i];
        arr[i]=a;
        arr[k]=a;
    }
}
