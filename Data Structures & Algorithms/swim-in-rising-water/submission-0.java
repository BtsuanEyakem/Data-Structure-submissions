class Solution {
    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
    /*
    Input: grid = [
        [0,1,2,10],
        [9,14,4,13],
        [12,3,8,15],
        [11,5,7,6]
    ]

     minHeap<grid[i][j],i,j> = PriorityQueue<>(Comparator.comparingInt(a->a[0])

      curr = minHeap.poll();
      dis = Math.max(dis,cur[0]);

      if(i=n-1 & j = n-1) return dis

    */
      int ROW = grid.length;
      int COLM = grid[0].length;

      int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
      PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
      q.offer(new int[]{grid[0][0],0,0});
      int dis = Integer.MIN_VALUE;

      while(!q.isEmpty()){
         int[] cur = q.poll();
         visited[cur[1]][cur[2]] = true;
         dis = Math.max(dis, cur[0]);

         if(cur[1] == ROW-1 && cur[2]==COLM-1) break;

         for(int[] dir: dirs){
            int x = cur[1]+dir[0];
            int y = cur[2]+dir[1];

            if(x >= COLM || y >= ROW || x < 0 || y < 0 || visited[x][y]) continue;

            q.offer(new int[]{grid[x][y],x,y});
         }
      }

      return dis;   
        
    }
}










