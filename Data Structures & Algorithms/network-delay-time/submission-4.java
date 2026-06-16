class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // BFS
        // int dist = -1;
        HashMap<Integer,List<int[]>> adjacency = new HashMap<>();
	    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int[] time: times){
            int start = time[0];
            int des = time[1];
            int dis = time[2];
            adjacency.computeIfAbsent(start, key -> new ArrayList<>()).add(new int[]{des,dis});
        }

       // times=[[2,1,1],[2,3,1],[3,4,1]]      n=4     k=2
       /*
       visited = {2,1,3,4}   minHeap ={[2,1,0],{[1,2,1],[3,2,1],    {[4,3,2]}
       2 -> {[1,1],[3,1]}
       3 -> {[4,1]}
       curr = [3,2,1]
           4
        1 ==> 2
      1 |    9| 1 \ 3
        3 ==> 4 => 5
          1.    7

        4+9+7 = 20
      
      {{9,5},{13,4},  5,5}}
      {5,5}
      dis = 5

       */

      HashSet<Integer> visited = new HashSet<>();
      minHeap.offer(new int[]{k,1,0});
       int dis = 0;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            if(visited.contains(curr[0])) continue;
            visited.add(curr[0]);
           // dis = curr[2];
            if(visited.size() == n) {
                dis =  curr[2];
             }

            for(int[] adj : adjacency.getOrDefault(curr[0], new ArrayList<>())){
                  if(visited.contains(adj[0])) continue;
                    minHeap.offer(new int[]{adj[0],curr[1]+1,adj[1]+curr[2]});
                 }

            }
            return visited.size() == n ? dis : -1;
        
    }
         
}
