package leetcode.offer;

public class OfferClimbStairs_70 {

    public static void main(String[] args) {
        int i = new OfferClimbStairs_70().climbStairs(10);
        System.out.println(i);
    }


    public int climbStairs(int n) {

        int first=0;
        int second=1;
        for (int i=0;i<n;i++){
            int temp=second;
            second=first+second;
            first=temp;
        }
        return second;
    }

    public int climbStairs2(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        return climbStairs(n-1) +climbStairs(n-2);
    }
}
