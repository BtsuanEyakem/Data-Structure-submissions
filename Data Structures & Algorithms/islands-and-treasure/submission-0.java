class Solution {
   // int[][] grid2;
    public void islandsAndTreasure(int[][] grid) {
        LinkedList<int[]> q = new LinkedList<>();
        for(int i=0; i < grid.length; i++){ 
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                        q.offer(new int[]{i,j});
                }
            }
        }
        int dis =0;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i < len; i++){
                int[] cur = q.poll();
                int y = cur[0];
                int x = cur[1];
                for(int[] d: dir){
                    int ny = d[0]+y;
                    int nx = d[1]+x;
                    if(ny < 0 || nx < 0 || ny >= grid.length || nx >= grid[0].length || grid[ny][nx] != Integer.MAX_VALUE)  continue;

                    grid[ny][nx] = dis+1;
                    q.offer(new int[]{ny,nx});

                }
            }

            dis++;
        }

    }
}
 
/*
Tc = n* n*m
Input: [
  [2147483647,      -1,         0,   1],
  [2, 2,   1,    -1],
  [1,      -1,      2147483647,    -1],
  [0,               -1,      2147483647,  2147483647]
]

queue {{0,2}, {3,0}} dis = 0
{{1,2},{0,3},{2,0}}.  dis = 1
 dist= 0. {0,2}.  for i ->q.size() 
 {{0,1},{1,0},{0,-1},{-1,0}}
 i, j 
*/