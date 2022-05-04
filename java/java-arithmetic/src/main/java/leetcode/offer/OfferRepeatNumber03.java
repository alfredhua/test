package leetcode.offer;

import lombok.val;

import java.util.HashMap;
import java.util.Map;

public class OfferRepeatNumber03 {

    public static void main(String[] args) {
        OfferRepeatNumber03 offerRepeatNumber03 = new OfferRepeatNumber03();
        int repeatNumber = offerRepeatNumber03.findRepeatNumber(new int[]{2, 3, 1,0,2,5,3});
        System.out.println(repeatNumber);
    }

    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num:nums){
            if (map.containsKey(num)){
                return num;
            }
            map.put(num,1);
        }
        return 0;
    }
}
