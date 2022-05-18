package leetcode.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] bubble = new BubbleSort().bubble(new int[]{4, 5, 3, 7, 1, 9});
        System.out.println(bubble);

    }
    public int[] bubble(int[] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<n-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
