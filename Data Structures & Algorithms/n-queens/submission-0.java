class Solution {
    // return all solutions to n-queens puzzle
    // queen can attach horizontaly, vertically & diagonaly  
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i < board.length; i++){
            Arrays.fill(board[i],'.');
        }
        dfs(0,n,board,new HashSet<>(),new HashSet<>(),new HashSet<>(),new HashSet<>());
 
        return res;
    }
    // res = {[[Q],[.] ]}  board = [[....],[....],[....],[....]]
  //  "...Q",
  //  ".Q..",
  //  "Q...",
  //  "..Q."
  // j =1 i = 1
  // posDia = 0
  // negDia = 0
  // j = 0  i = 2
   // posDia = -2
   // negDia = 2
  

/// n= 1
// board [['Q']]
// dfs(0,1,board,{0},{0},{0})
// i = 0 j=0 pos= 0 neg = 0
// dfs(1,1,board,{0},{0},{0})
    public void dfs(int i, int n, char[][] board, HashSet<Integer> visitedRow, HashSet<Integer> visitedCol, HashSet<Integer> posDia, HashSet<Integer> negDia){
        System.out.println("Hello from DFS");
        if(i == n){
            List<String> soln = new ArrayList<>();
            for(char[] chr: board){
                soln.add(new String(chr));
            }
            res.add(new ArrayList<>(soln));
            return;
        }

        for(int j =0; j < n; j++){
            int posDiav = j-i;
            int negDiav = i+j;
            if(visitedRow.contains(i) || visitedCol.contains(j) || posDia.contains(posDiav) || negDia.contains(negDiav)){   
                continue;
            }
            visitedRow.add(i);
            visitedCol.add(j);
            posDia.add(posDiav);
            negDia.add(negDiav);
            board[i][j] = 'Q';
            System.out.println("Hello while "+board[i][j]);
            dfs(i+1,n,board, visitedRow, visitedCol,posDia,negDia);

            visitedRow.remove(i);
            visitedCol.remove(j);
            posDia.remove(posDiav);
            negDia.remove(negDiav);
            board[i][j] = '.';
        }

    }
    

   // Output: 
   //[[".Q..",
   //  "...Q",
   //  "Q...",
   //  "..Q."],
   
   //["..Q.","Q...","...Q",".Q.."]]
   //  i=0 j=0
   // (0,0)
   // (1,0),(1,1),(1,2),(1,3)

   // i=0 j= 0  rest = [ind][j] & [ind][0]  diff = visited  [ind+1][ind+1]/ [1,2] = 1 [0,1] [2,3]=1
   // postDia = j-i.    negDia= i-j
   // visitedRow=[0,1]   visitedCol=[0,2]   Dia=[0,1,-1]   negDiago=[0,-1]
   // if i in visitedRow
   // if j in visitedCol
   // if j-1 is posDai
   // if i-j is negDai
   // if i < 0 j < 0  dp[i][j] = #  skip i >= dp.len j >=dp.len
   // [[Q...],
   //  [....],
   //  [....],
   //  [....],
   //]


}
