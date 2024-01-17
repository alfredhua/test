package leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OfferOrangesRotting_994 {
    public static void main(String[] args) {
        int i = new OfferOrangesRotting_994().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] directions = { {-1,0},{1,0},{0,-1},{0,1} };//四个方向移动
        Queue<int[]> stack=new LinkedList<>();
        Stack<int[]> stack1=new Stack<>();
        int count=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j] == 2){
                    stack.add(new int[]{i,j});
                }
                if (grid[i][j]==1){
                    count++;
                }
            }
        }
        int minute=0; //腐烂的个数,不是轮数
        while (!stack.isEmpty() && count>0){
            //轮数
            minute++;
            int size = stack.size();
            //每一轮都扔出来，继续循环
            for (int k=0;k<size;k++){
                int[] pop = stack.poll();
                int row=pop[0],col=pop[1];
                //4个方向
                for (int[] dir:directions){
                    int nRow=row+dir[0];
                    int nCol=col+dir[1];
                    //防止越界
                    if (nRow>=0 && nRow<m && nCol>=0 && nCol<n && grid[nRow][nCol]==1){
                        //好橘子被腐烂
                        grid[nRow][nCol] = 2;
                        count--;
                        stack.add(new int[]{nRow,nCol});
                    }
                }
            }
        }
        return count>0?-1:minute;
    }
}
