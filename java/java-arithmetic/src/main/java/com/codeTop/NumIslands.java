package com.codeTop;

public class NumIslands {

    public static void main(String[] args) {
        char[][] grid = { {1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        NumIslands numIslands = new NumIslands();
        int i = numIslands.numIslands(grid);
        System.out.println(i);

    }

    public int numIslands(char[][] grid) {
        int num=0;
        for (int r=0 ;r<grid.length;r++ ){
            for (int c=0 ;c<grid[0].length;c++ ) {
                if (grid[r][c]==1){
                    num++;
                    dfs(grid,r,c);
                }
            }
        }
        return num;
    }


    // row column
    public void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if (r>nr-1 || r<0 || c>nc-1||c<0 || grid[r][c] =='0' ){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }




}
