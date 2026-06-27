class Solution {
    public int maxProfit(int[] prices) {
        // prices = [10,4,5,6,7,1,8]
       // l = 5  r = 6  val=7   max=
       // 
        int max = 0;
        int l = 0;
        int r = l+1;
        while (r < prices.length){
            if(prices[r] < prices[l]){
                l = r;
                r = l+1;
            }else{
                int val = prices[r]-prices[l];
                max = Math.max(val,max);
                r++; 
            }
             
        }
        return max;
    }
}
