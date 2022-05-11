package leetcode.offer;

import java.util.Stack;

public class OfferMaxAreaOfIsland_695 {

    public static void main(String[] args) {
        int i = new OfferMaxAreaOfIsland_695().maxAreaOfIsland(new int[][]{{0, 0, 0, 1,1,1, 0, 0}});
        System.out.println(i);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int result=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==0){
                    continue;
                }
                Stack<int[]> stack=new Stack<>();
                stack.push(new int[]{i,j});
                int cur=0;
                while (!stack.isEmpty()){
                    int[] current = stack.pop();
                    int x=current[0];
                    int y=current[1];
                    if (x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y] == 0) {
                        continue;
                    }
                    cur++;
                    grid[x][y]=0;
                    int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
                    for (int[] dir:directions){
                        int row=current[0]+dir[0];
                        int col=current[1]+dir[1];
                        stack.push(new int[]{row,col});
                    }
                }
                result=Math.max(result,cur);
            }
        }
        return result;
    }

    public int maxAreaOfIsland1(int[][] grid) {
        int result=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                result =Math.max(result,dfs(grid,i,j));
            }
        }
        return result;
    }

    public int dfs(int[][] grid,int row,int col){
        if (row<0||row>grid.length-1||col<0||col>grid[0].length-1 || grid[row][col] != 1){
            return 0;
        }
        int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int ans = 1;
        grid[row][col]=0;
        for (int[] dir:directions){
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            ans= ans+dfs(grid,newRow,newCol);
        }
        return ans;
    }
}
