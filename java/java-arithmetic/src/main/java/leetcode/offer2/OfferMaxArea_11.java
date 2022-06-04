package leetcode.offer2;

public class OfferMaxArea_11 {
    public static void main(String[] args) {
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int res=0;
        while (i<j){
            res = height[i] < height[j] ? Math.max(res,(j-i)*height[i++]): Math.max(res,(j-i) * height[j--]);
        }
        return res;
    }
}
