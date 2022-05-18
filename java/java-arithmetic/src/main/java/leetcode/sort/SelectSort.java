package leetcode.sort;

/**
 * 选择排序,每次在剩余的数组中找最小的,放在相应的位置
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] sort = new SelectSort().sort(new int[]{4, 5, 3, 7, 1, 9});
        System.out.println(sort);
    }

    public int[] sort(int[] arr) {
        for (int i= 0;i<arr.length-1;i++){
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min]){
                    min=j;
                }
            }
            if (i!=min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}
