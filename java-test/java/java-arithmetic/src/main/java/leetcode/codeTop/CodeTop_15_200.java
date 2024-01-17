package leetcode.codeTop;

public class CodeTop_15_200 {

    public static void main(String[] args) {

    }


    int[][] direction = {{0,-1},{0,1},{-1,0},{1,0}};

    public int numIslands2(char[][] grid) {
        int result =0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if ('1' == grid[i][j]){
                    for (int[] dir: direction){
                        int newI= i + dir[0];
                        int newJ= j + dir[1];
                        if (newI>0 && newI<grid.length && newJ>0 && newJ<grid[0].length){
                            grid[newI][newJ] = '0';
                        }
                    }
                    grid[i][j] = '0';
                }
                result++;
            }
        }
        return result;
    }

    public int numIslands(char[][] grid) {
        int result =0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if ('1' == grid[i][j]){
                    dfs(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}

