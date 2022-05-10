package leetcode.offer;

import lombok.val;

import java.util.Stack;

public class OfferFloodFill_733 {

    public static void main(String[] args) {
        int[][] ints = new OfferFloodFill_733().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        int[][] ints2 = new OfferFloodFill_733().floodFill(new int[][]{{0,0,0}, {0,0, 0}}, 1, 1, 2);
        int[][] ints3 = new OfferFloodFill_733().floodFill(new int[][]{{0,0,0}, {0,1, 0}}, 1, 1, 2);
        System.out.println("-----");
    }



    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor=image[sr][sc];
        if (currColor ==newColor){
            return image;
        }
        dfs(image,sr,sc,currColor,newColor);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int currColor,int newColor){
        if (image[sr][sc] == currColor){
            image[sr][sc] =newColor;
            int[][] dir=new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
            for (int[] nextDir : dir) {
                int x = sr + nextDir[0];
                int y = sc + nextDir[1];
                if (x < 0 || y < 0 || x > image.length - 1 || y > image[0].length - 1) {
                    continue;
                }
                dfs(image, x, y, currColor, newColor);
            }
        }
    }



    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int currColor=image[sr][sc];
        if (currColor ==newColor){
            return image;
        }
        // 上 右 下 左
        int[][] dir=new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
        boolean[][] exists=new boolean[image.length][image[0].length];
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{sr,sc});
        image[sr][sc]=newColor;
        while (!stack.isEmpty()){
            int[] current = stack.pop();
            for (int[] nextDir : dir) {
                int x = current[0] + nextDir[0];
                int y = current[1] + nextDir[1];
                if (x < 0 || y < 0 || x > image.length - 1 || y > image[0].length - 1 || exists[x][y]) {
                    continue;
                }
                if (image[x][y] == currColor) {
                    image[x][y] = newColor;
                    exists[x][y] = true;
                    stack.push(new int[]{x, y});
                }
            }
        }
        return image;
    }


}
