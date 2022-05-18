package leetcode.sort;

/**
 * 插入排序,从小到大排序
 */
public class InsertSort {

    public static void main(String[] args) {
//        int[] sort = new InsertSort().sort(new int[]{4, 5, 3, 7, 1, 9});
        int[] sort2 = new InsertSort().sort2(new int[]{4, 5, 3, 7, 1, 9});
        System.out.println(sort2);
    }


    public int[] sort2(int[] arr) {
        for (int i=1;i<arr.length;i++){
            int insert=arr[i];
            int j=i;
           while (j>0 && insert>arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            if (j!=i){
                arr[j] = insert;
            }
        }
        return arr;
    }



    public int[] sort(int[] arr) {
        for (int i=1;i<arr.length;i++){
            //从第二个位置开始，因为第一个位置是一个数字，本身是有序的
            int insert =arr[i]; //要插入的数字
            // 将 insert 插入到0 - i 的某一个位置
            for (int j=0;j<i;j++){
                if (insert<arr[j]){
                    //此时 arr[j] 就是insert的插入的位置
                    int temp=arr[j];
                    arr[j] = insert;
                    //从j 到i 要往后挪一个
                    int k=j+1;
                    while (k<=i){
                        int x=arr[k];
                        arr[k]=temp;
                        temp=x;
                        k++;
                    }
                    break;
                }

            }
        }
        return arr;

    }

}
