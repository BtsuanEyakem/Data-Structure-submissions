class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
   List<List<Integer>> result = new ArrayList<>();
   Arrays.sort(candidates);
    dfs(0,0,target, candidates, new ArrayList<>(), result);
    return result;
}

public void dfs(int i,int sum,int target,  int[] candidates, List<Integer> list, List<List<Integer>> result) {
    if(sum == target) {
        result.add(new ArrayList<>(list));
        System.out.println("i "+i+ " sum "+ sum + " list "+ list);
        return;
    }
    if(i >= candidates.length || sum > target) return;

   list.add(candidates[i]);
   dfs(i+1, sum+candidates[i], target, candidates, list, result);
    list.remove(list.size()-1);
   while(i < candidates.length-1 && candidates[i+1] == candidates[i]){
        i++;
     }
   dfs(i+1,sum,target, candidates,list,result);
}

}