class Solution {
    HashSet<Integer> visited = new HashSet<>();
    HashMap<Integer, List<Integer>> conn = new HashMap<>();

    public int countComponents(int n, int[][] edges) {

        for(int i=0; i < n; i++){
            conn.put(i,new ArrayList<>());
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            conn.get(a).add(b);
            conn.get(b).add(a);
        }
        int count = 0;
        for(int i=0; i < n; i++){
            if(visited.contains(i)) continue;
                dfs(i,-1);
                count++;
            }
        return count;
    
     }
    public void dfs(int n, int prev){
        if(conn.get(n).isEmpty() || visited.contains(n)) return;
        visited.add(n);
        
        for(int negi: conn.get(n)){
            if(negi == prev) continue;
            dfs(negi, n);
        }
    }

}
