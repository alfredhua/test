package leetcode.review.window;

public class MinSubArrayLen {

    public static void main(String[] args) {

    }


    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int temp = 0;
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            temp = temp + nums[end];
            while (temp > target) {
                ans = Math.min(ans, end - start + 1);
                temp = temp - nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
