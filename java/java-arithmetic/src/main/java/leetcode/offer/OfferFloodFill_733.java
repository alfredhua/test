package leetcode.offer;

import lombok.val;

import java.util.Stack;

public class OfferFloodFill_733 {

    public static void main(String[] args) {

    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor=image[sr][sc];
        if (currColor ==newColor){
            return image;
        }
        // 上 右 下 左
        int[][] dir=new int[][]{{0,-1},{1,0},{-1,0},{}};
        boolean[][] exists=new boolean[image.length][image[0].length];
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{sr,sc});
        while (!stack.isEmpty()){
            int[] current = stack.pop();

        }
        return image;
    }


}
