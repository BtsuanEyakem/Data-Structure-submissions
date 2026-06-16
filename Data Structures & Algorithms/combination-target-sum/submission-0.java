class Solution {
     public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(0,0,candidates,new ArrayList<>(), result,target);
        return result;
}

public void backtracking(int i, int sum, int[] nums, List<Integer> list, List<List<Integer>> result,int target){
     
   if(sum > target) return;
   if(sum == target) {
            result.add(new ArrayList<>(list));
	return;
     }

  for(int j=i; j < nums.length; j++){
         list.add(nums[j]);
        backtracking(j,sum+nums[j],nums,list,result,target);
        list.remove(list.size()-1);
    }
}
}
