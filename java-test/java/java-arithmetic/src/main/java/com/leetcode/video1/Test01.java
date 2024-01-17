package com.leetcode.video1;

public class Test01 {


    public static void main(String[] args) {
        int[] a=new int[]{0,1,0,3,12};
        int[] result=getNewArray(a);
        System.out.println(result);
    }

    public static int[] getNewArray(int[] array){
        int k=0;
        for (int i=0;i<array.length;i++){
            if (array[i]!=0){
                array[k]=array[i];
                k++;
            }
        }
        for (int j=k;j<array.length;j++){
            array[j]=0;
        }
        return array;
    }

}
