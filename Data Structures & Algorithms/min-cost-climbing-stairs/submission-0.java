class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0]= cost[0];
        dp[1] = cost[1];
        //[1,2,3,1]
        //dp[0]= 1
        //dp[1]=2
        //dp[2] = 4
        //dp[3] =3    dp[1]cost[3]= 2+1 = 3 , dp[2]cost[3] = 4+1 = 5
        // dp[0]+cost[2], dp[1]cost[2] = 1+3 = 4 // 2+3 = 5 

        for(int i=2; i < cost.length; i++){
            dp[i] = Math.min(dp[i-2]+cost[i],dp[i-1]+cost[i]);
        }

        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}
