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
//        ArrayUtils.compare(result,SortTest.mergeSort(Arrays.copyOf(result, result.length)));
        ArrayUtils.compare(result,SortTest.quickSort(Arrays.copyOf(result, result.length)));
    }

    /**
     * 快排,每次选择最后一个数为基数，小于该数的在前面,大于的放在后面
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr){
        if (arr.length<2){
            return arr;
        }
        quickSort2(arr,0,arr.length-1);
        return arr;
    }

    public static void quickSort2(int[] arr,int left,int right){
        if (left<right){
            int partition = partition(arr, left, right);
            quickSort2(arr,left,partition-1);
            quickSort2(arr,partition+1,right);
        }
    }

    /**
     * 找基准位置，比该数大的放在前面，比该数小的放在后面，该数放在中间
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right){
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    /**
     * 归并排序
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr){
        if (arr.length<2){
            return arr;
        }
        int mid = arr.length/2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
        int[] left = mergeSort(leftArr);
        int[] right = mergeSort(rightArr);
        return merge(left,right);
    }

    public static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        int i = 0, j = 0,k=0;
        while (i<left.length && j<right.length){
            result[k++] = left[i]<right[j] ? left[i++] : right[j++];
        }
        if (i == left.length){
            while (j<right.length){
                result[k++] = right[j++];
            }
        }
        if (j == right.length){
            while (i<left.length){
                result[k++] = left[i++];
            }
        }
        return result;
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

    private static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
