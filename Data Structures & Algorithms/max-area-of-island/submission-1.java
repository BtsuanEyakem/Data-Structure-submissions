class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        for(int i=0; i < n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] ==1){
                 int value = dfs(i,j,grid);
                  max = Math.max(value, max);
                }
            }
        }
        return max;
    }

    public int dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] ==0) return 0;

        int value = 1;
            
        grid[i][j] = 0;

          value += dfs(i+1,j,grid);
          value += dfs(i-1,j,grid);
          value += dfs(i,j-1,grid);
          value += dfs(i,j+1,grid);

    return value;

    }
}
/*

Input: grid = [
  [0,1,1,1,0],
  [1,0,0,0,1],
  [0,1,1,0,1],
  [0,1,0,0,1]
]

value = 1
value(1) += dfs(1+1,1); = 1
value = 1+ dfs(-1,1) = 1
value +=dfs(1,2)
int value = 1 +0 = 1
value += 


value = 0 
valu= 0+0 
dfs(i-1,j,grid) + value = 0+0 =0
value = 0 + dfs(i,j-1) 

int value = 0;
dfs(0+1,2) 
int value = 0;
value += dfs(1+1,2) = 0
int value = 0;
dfs(2+1,2) = 0



 value = dfs(1+1,1,grid)+1
   dfs(1+1,1+1,grid)+1 = 1
 value = dfs(2,1+1,grid)+1
 value = dfs(2,2+1,grid)+1
 value = dfs(2-1,2,grid)+1 = 2+1 = 3
 value = dfs(2,2+1,grid)+1 0+1=  2
Input: grid = [
  [0,1,1,0,1],
  [1,0,1,0,1],
  [0,1,1,0,1],
  [0,1,0,0,1]
]


*/