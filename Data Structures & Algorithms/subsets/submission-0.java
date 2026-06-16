class Solution {
    List<List<Integer>> result = new ArrayList<>();
   public List<List<Integer>> subsets(int[] nums){
           backtracking(0,nums,new ArrayList<>());
           return result;
    }

public void backtracking(int i, int[] nums, List<Integer> list){
  if(i == nums.length){
         result.add(new ArrayList<>(list));
 	 return;
    }


         list.add(nums[i]);
        backtracking(i+1, nums,list);
        list.remove(list.size()-1);
        backtracking(i+1, nums, list);
    
}
}
