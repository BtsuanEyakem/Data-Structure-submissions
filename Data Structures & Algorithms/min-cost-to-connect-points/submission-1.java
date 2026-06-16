class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        HashMap<Integer,List<int[]>> connection = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i =0; i< points.length; i++){
            for(int j=0; j < points.length; j++){
            if( i == j) continue;
            int dis = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            connection.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dis,j});
            }
        }

        minHeap.offer(new int[]{0,0});
        HashSet<Integer> visited = new HashSet<>();
        int dis = 0;
        int total = 0;
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int index = cur[1];
            if(visited.contains(index)) continue;
            dis+= cur[0];
            visited.add(index);
            if(visited.size() == points.length) return dis;
            
            
        for(int[] negi: connection.get(index)){
               if(visited.contains(negi[1])) continue;
                minHeap.offer(new int[]{negi[0],negi[1]});
            }

         }

         return 0;

    }
}
// [[0,0],[2,2],[3,3]
/*
    0 -> {[4,1],[6,2]
    1 -> {[4,0],[2,2]
    2 -> {[6,0],[2,1]

    minHip = {[6,2],[12,0],[8,1]}   dis = 6   ind=2    cur =   visi ={0,1,2}
*/







