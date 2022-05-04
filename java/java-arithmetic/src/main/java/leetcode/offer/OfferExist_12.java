package leetcode.offer;

public class OfferExist_12 {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        boolean[][] exists=new boolean[board.length][board[0].length];
        int k=0;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                boolean flag=check(i,j,board,word,0,exists);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(int row,int column,char[][] board,String word,int k,boolean[][] exists){
        char c = word.charAt(k);
        if (board[row][column]!=c){
            return false;
        }
        // 终止条件，遍历完成
        if (k==word.length()-1){
            return true;
        }
        exists [row][column]=true;
        boolean result=false;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir:directions){
            int newRow=row + dir[0];
            int newColumn= column +dir[1];
            //控制边界，防止越界, 如果已经走过了，则不进行再次走
            if (newRow>=0 && newColumn >=0 && newRow<=board.length-1 && newColumn <= board[0].length-1 ){
                if (!exists[newRow][newColumn]){
                    boolean flag = check(newRow, newColumn, board, word, k + 1, exists);
                    if (flag){
                        result=true;
                        break;
                    }
                }
            }

        }
        exists[row][column]=false;
        return result;
    }



}
