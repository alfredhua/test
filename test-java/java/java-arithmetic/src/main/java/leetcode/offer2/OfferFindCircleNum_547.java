package leetcode.offer2;

import java.util.LinkedList;
import java.util.Queue;

public class OfferFindCircleNum_547 {
    public static void main(String[] args) {
        int circleNum = new OfferFindCircleNum_547().findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}});
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] isConnected){
        int cities = isConnected.length;  //  城市数量
        boolean[] visited=new boolean[cities];
        int provinces =0;
        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<isConnected.length;i++){
            if (!visited[i]){
                queue.offer(i);
                while (!queue.isEmpty()){
                    Integer j = queue.poll();
                    visited[j] =true;
                    for (int k =0;k<cities;k++){
                        if (isConnected[j][k] == 1 && !visited[k]){
                            queue.offer(k);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }
}
