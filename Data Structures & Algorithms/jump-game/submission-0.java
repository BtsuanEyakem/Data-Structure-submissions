class Solution {
    public boolean canJump(int[] nums) {
        int caryOn = 1;

        for(int i=nums.length-2; i >=0; i--){
            if(nums[i] >= caryOn){
                caryOn = 1;
            }else{
                caryOn = caryOn + 1;
            }
        }
        return caryOn == 1 ? true : false;
        
    }
}


//  [3,4,0,0,3,0,4]
//  [1,2,4,7,1]