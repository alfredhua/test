package leetcode.offer;

import java.util.Stack;

public class OfferUpdateMatrix_542 {

    public static void main(String[] args) {
        int[][] a=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] ints = new OfferUpdateMatrix_542().updateMatrix(a);
        System.out.println("-------");
    }

    public int[][] updateMatrix(int[][] mat) {
        boolean[][] seen = new boolean[mat.length][mat[0].length];
        Stack<int[]> queue = new Stack<int[]>();
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                if (mat[i][j]==0){
                    queue.push(new int[]{i,j});
                    seen[i][j]=true;
                }
            }
        }

        int[][] result=new int[mat.length][mat[0].length];
        while (!queue.isEmpty()){
            int[] current = queue.pop();
            int row=current[0];
            int col= current[1];
            int[][] directions=new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
            for (int[] dir:directions){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if (newRow>=0 && newRow<mat.length && newCol>=0 && newCol<mat[0].length && !seen[newRow][newCol]){
                    result[newRow][newCol]=result[row][col]+1;
                    queue.push(new int[]{newRow,newCol});
                    seen[newRow][newCol]=true;
                }
            }
        }
        return result;
    }
}
