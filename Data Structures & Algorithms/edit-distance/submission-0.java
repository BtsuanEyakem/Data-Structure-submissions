class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int j=0; j<=n; j++){
            dp[m][j] = n-j;
        }
        for(int i=m; i >=0; i--){
            dp[i][n] = m-i;
        }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                dp[i][j] = dp[i+1][j+1];
                if(word1.charAt(i) != word2.charAt(j)){
                   int value = Math.min(dp[i+1][j], dp[i][j+1]);
                   dp[i][j] = Math.min(value,dp[i][j])+1;
                }
            }
        }

       return dp[0][0]; 
    }

/*              i
    word1 = "neatcdee", 
                j
    word2 = "neetcode"
    k l m
 l 
 m  3 2 1
 e  3 2 1

    n   e   a   t   c   d   e   e
n
e
a
t
c
d                                    3
e                                1   2
e   6   5   5   5   4    2   1   0   1
    8   7   6   5   4    3   2   1   0

dp[m][0] = 8
dp[m][8] = 0. j=8
""  given = "dee"
"dee"  soln =""
n-1

if the last arrays are not the same 
    j=n; j> 0
    dp[m][j]



    // if  wor i == wor2 char j


    n   e   a


*/
}
