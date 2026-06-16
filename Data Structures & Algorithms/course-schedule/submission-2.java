class Solution {
    HashMap<Integer,List<Integer>> map = new HashMap<>();
     HashSet<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i=0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] pre: prerequisites){
            int curr = pre[0];
            int must = pre[1];
            map.get(curr).add(must);
        }

        for(int i=0; i < numCourses; i++){
           
            if(!dfs(i)){
                return false;
            }
        }

        return true;

    }
    public boolean dfs(int cources){
        if(visited.contains(cources)) return false;
        if(map.get(cources).isEmpty()) return true;

        visited.add(cources);

        for(int pre: map.get(cources)){
            if(!dfs(pre)) return false;
        }
        map.put(cources, new ArrayList<>());
        visited.remove(cources);
        return true;

    }
}
