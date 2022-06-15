package leetcode.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guozhenhua
 * @date 2022/6/15
 */
public class ArrayUtils {


    public static void main(String[] args) {
//        List<int[]> ints = ArrayUtils.generateArray( 5);
//        ints.forEach(System.out::println);
        List<int[]> ints1 = ArrayUtils.generatorSortArray(3);
    }

    /**
     * 生成指定count 个数组，如果size = 0 ，则数组大小随机
     * @param count
     * @return
     */
    public static List<int[]> generateArray(int count){
        List<int[]> list = new ArrayList<>();
        count = count==0 ? 1:count;
        for (int i =0;i<count;i++){
            int length = (int)(Math.random()*10);
            int[] result = new int[length];
            for (int j =0;j<length;j++){
                result[j] = (int) (Math.random() * 100);
            }
            list.add(result);
        }
        return list;
    }

    public static List<int[]> generatorSortArray(int count){
        List<int[]> ints = generateArray(count);
        ints.forEach(Arrays::sort);
        return ints;
    }

}
