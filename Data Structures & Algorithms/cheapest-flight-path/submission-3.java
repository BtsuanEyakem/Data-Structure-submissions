class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,List<int[]>> connection = new HashMap<>();
        for(int[] flight : flights){
            connection.computeIfAbsent(flight[0], p -> new ArrayList<>()).add(new int[]{flight[1],flight[2]});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        HashSet<Integer> visited = new HashSet<>();
        int dis = Integer.MAX_VALUE;
        minHeap.offer(new int[]{k+1,src,0});
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            visited.add(cur[1]);
            if(cur[1] ==dst) { dis = Math.min(dis,cur[2]);}
            if(cur[0] <= 0) continue;
            for(int[] neig: connection.getOrDefault(cur[1], new ArrayList<>())){
                   if(cur[0] <= 0 || visited.contains(neig[0])) continue;
                    minHeap.offer(new int[]{cur[0]-1,neig[0],cur[2]+neig[1]});
            }
        }
        return dis == Integer.MAX_VALUE ? -1 : dis;

    }
}

// TC = O(E+V)
// SC = O()
//      0 -- 1
//       \  /
//.        2
