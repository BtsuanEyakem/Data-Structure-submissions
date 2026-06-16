class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i=2; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
   // n= 4
   // dp[1,1,2,3,5]
   // dp[2] = dp[1]+dp[0] =2
   //dp[3] = dp[2]+dp[1] = 0+
   // dp[4] = dp[3]+dp[2]
}
