package leetcode.offer;

public class OfferMinArray_11 {

    public static void main(String[] args) {

    }

    public int minArray(int[] numbers){
        if (numbers.length<2){
            return numbers[0];
        }
        int left=0;
        int result=-1;
        for (int right=1;right<numbers.length;right++){
            if (numbers[left]>numbers[right]){
                result=numbers[right];
                break;
            }
        }
        if (result==-1){
            result=numbers[0];
        }
        return result;
    }
}
