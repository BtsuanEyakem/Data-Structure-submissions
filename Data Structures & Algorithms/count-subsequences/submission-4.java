class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int j=0; j<=m;j++){
            dp[n][j] = 1;
        }

        for(int i= n-1; i >=0; i--){
            for(int j=m-1; j>=0; j--){
                if(t.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]+dp[i][j+1];
                }else{
                    dp[i][j] = dp[i][j+1];
                }
            }
        }
        
       // return dfs(0,0,s,t,new HashMap<>());
       return dp[0][0];
    }
    public int dfs(int i, int indx, String s, String t, HashMap<Integer,Integer> set){
        if(indx == t.length()) return 1;
        if(i == s.length() ) return 0;
        if(set.containsKey(i)) return set.get(i);
        int value = 0;

        for(int j=i; j< s.length(); j++){
             if(s.charAt(j) == t.charAt(indx)){
                 value += dfs(j+1,indx+1,s,t,set);
                 set.put(i,value);
             }
        }

        return value;

    }
}
/*
caaaat
s="xxyxxxy"
t="xy"

s="rabbbit"
t="rabbit"

    r   a   b   b   b   i   t
r
a
b                        0   0
b   3   3   3   2    1   0   0
i   1   1   1   1    1   1   0                       
t   1   1   1   1    1   1   1





    x   x   y   x   y
x   5   3   1   1   0
y   2   2   2   1   1

if not equal dp[i][j] = dp[i][j+1]
if equal dp[i][j] = dp[i+1][j]+dp[i][j+1]



i=0/1   j=0/2    indx = 0    s = "xxyxy", t = "xy"

value = 1+1 = 2      
j=i=0   dfs(0+1,0+1,s,t)

j= 1   dfs(1+1,0+1,s,t)
i=j=2   dfs(2+1,1+1,s,t)=1 done    indx=1
j= 1   dfs(2+1,0+1,s,t) done
j= 1   dfs(3+1,0+1,s,t) v=2 done

j=i=0   dfs(0+1,0+1,s,t)




                   
*/