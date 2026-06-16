class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i = s.length()-1; i >=0; i--){
            for(int j=0; j < wordDict.size(); j++){
                int wlen = wordDict.get(j).length();
                int len = s.length()-i;
                if(len >= wlen){
                    String sub = s.substring(i,i+wlen);
                    if(sub.equals(wordDict.get(j)) && dp[i+wlen]){
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[0];
        
    }
}

// "neetcode"
// ["neet","code"]
// i= 4   s.len = 8 
// dp = [0,0,0,0,0,0,0,0,true]
// wlen = 4.      len = 4
// sub = code




