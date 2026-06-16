class Solution {
    public int maxSubArray(int[] nums) {
        int prevMax = nums[0];
        int res = prevMax;

        for(int i=1; i < nums.length; i++){
            
            prevMax = Math.max(prevMax+nums[i], nums[i]);
            res = Math.max(prevMax,res);
        }

        return res;
    }

    // 2,-3,4,-2,2,1,-1,4].   [-3,-1,-5]
    // i=2        prev = -5                   res = -1     

}
