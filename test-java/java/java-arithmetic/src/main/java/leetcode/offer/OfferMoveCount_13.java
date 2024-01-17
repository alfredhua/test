package leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

public class OfferMoveCount_13 {

    public static void main(String[] args) {

    }
    public int movingCount(int m, int n, int k) {
        return 0;
    }


//    public int movingCount(int m, int n, int k) {
//        if (k ==0){
//            return 1;
//        }
//        Queue<int[]> queue=new LinkedList<>();
//        int[] dx = { 0, 1 };
//        int[] dy = { 1, 0 };
//        boolean[][] exists=new boolean[m][n];
//        queue.offer(new int[]{0,0});
//        exists[0][0] = true;
//        int result=1;
//        while (!queue.isEmpty()){
//            int[] cell = queue.poll();
//            int x = cell[0];
//            int y = cell[1];
//            for (int i =0;i<2;i++){
//                int newX = dx[i] + x;
//                int newY = dy[i] + y;
//                if (newX < 0 || newY<0 || newX >= m || newY >=n || exists[newX][newY]){
//                    continue;
//                }
//                queue.offer(new int[]{newX,newY});
//                exists[newX][newY] =true;
//                result++;
//            }
//        }
//        return result;
//    }


}
