package leetcode.sort;

import leetcode.helper.ArrayUtils;

import java.util.Arrays;

/**
 * @author guozhenhua
 * @date 2022/6/15
 */
public class SortTest {
    public static void main(String[] args) {
        int[] result = ArrayUtils.generateArray(1);
        ArrayUtils.compare(result,SortTest.inset(Arrays.copyOf(result, result.length)));
    }

    /**
     * 插入排序
     */
    public static int[] inset(int[] arr){
        int n = arr.length;
        for (int i = 1 ;i<n;i++){
            int temp = arr[i];
            for (int j =0;j<=i;j++){
                // 如果插入当前j的位置, j的位置后移
                if (temp<arr[j]){
                    int k = arr[j];
                    arr[j] = temp;
                    temp = k;
                }
            }
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * 选择排序,每次从剩下的找最小的，放在开始的个位置上
     * @param arr
     */
    public void select(int[] arr){
        int n = arr.length;
        for (int i=0;i<arr.length;i++){
            int k =i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[k]>arr[j]){
                    k = j;
                }
            }
            //第k位置最小，与i换位置！
            if (k!=i){
                swap(arr,k,i);
            }
        }
    }

    /**
     * 冒泡排序,每次拿第一个和后一个比较，然后不断后移
     * @param arr
     */
    public void bubble(int[] arr){
        int n = arr.length;
        for (int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if (arr[j]<arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }

    }

    private void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
