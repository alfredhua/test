package leetcode.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guozhenhua
 * @date 2022/6/15
 */
public class ArrayUtils {

    /**
     * 生成指定count 个数组，如果size = 0 ，则数组大小随机
     * @param count
     * @return
     */
    public static int[] generateArray(int count){
        int length = (int)(Math.random()*10 + 5);
        int[] result = new int[length];
        for (int j =0;j<length;j++){
            result[j] = (int) (Math.random() * 100);
        }
        return result;
    }

    public static int[] generatorSortArray(int count){
        int[] result = generateArray(count);
        Arrays.sort(result);
        return result;
    }

    public static void compare(int[] arr,int[] sortArr){
        System.out.println("排序前："+Arrays.toString(arr));
        Arrays.sort(arr);
        if (Arrays.toString(arr).equals(Arrays.toString(sortArr))){
            System.out.println("执行结果相同");
            System.out.println("排序后："+Arrays.toString(sortArr));
            return;
        }
        System.out.println("执行结果错误");
        System.out.println("排序后："+Arrays.toString(arr));
        System.out.println("Arrays排序后："+Arrays.toString(sortArr));
    }

}
