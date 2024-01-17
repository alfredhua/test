package leetcode.type.arr;

public class MaxArea {
    public static void main(String[] args) {

        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int i = new MaxArea().maxArea(height);
        System.out.println(i);
    }

    public int maxArea2(int[] height) {
        int i=0;int j=height.length-1;
        int tall,len;
        int area=0;
        while(i<j){
            len= j-i;
            tall=height[i]<height[j]?height[i++]:height[j--];//固定一端，高度更小的那条边，向中间尝试
            if(len*tall>area){
                area=len*tall;
            }
        }
        return area;
    }


    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;

        int maxArea =0;
        while (left< right){
            int  k = right - left;
            int c =  height[left] < height[right] ? height[left++]: height[right--];
            int area = k * c;
            if ( area> maxArea){
                maxArea = area;
            }

        }
        return maxArea;
    }
}
