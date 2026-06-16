class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
       int[] dp = new int[amount+1];
       Arrays.fill(dp,Integer.MAX_VALUE);
       // dp[0]= 1;


       for(int i=0; i <= amount; i++){
          for(int j=0; j < coins.length; j++){
            if(i == coins[j]){
                dp[i] = 1;
            } else if(i > coins[j] && dp[i-coins[j]] < Integer.MAX_VALUE){
               // System.out.println("i "+i+" coins "+coins[j] + "dp[coins] "+dp[coins[j]] + " dp "+dp[i]);
                dp[i] = Math.min(dp[coins[j]]+dp[i-coins[j]],dp[i]);
            }
          }
       }

       return dp[amount] >= Integer.MAX_VALUE ? -1 :  dp[amount];
        
    }
}
// [1,5,10]
//[1,1,2,3,4,1,2,inf,inf,inf,inf,inf]

// [4]. 7 1+
// coins
// amount 
//          1           5           10
//        1.  5
//      1    1. 5

// [1,2,3,4,1,6/2,3,7,0,1,0,0]
// dp[5]+ 7 =  1+ 7 = 8 
// dp[10]+dp[2] = 3
// dp[1]+ dp[1]
// dp[2]+dp[10]

// [6,7] amount = 10
// [inf]
// dp[4]+dp[6]

// i=0 
// dp[n] =n
// dp[7] = dp[1]+dp[7-1]
// dp[0]+dp[1]
// dp[1]+dp[1] = 2
