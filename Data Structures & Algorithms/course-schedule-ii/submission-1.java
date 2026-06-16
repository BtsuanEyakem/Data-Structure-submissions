class Solution {
        
        int[] res;
        HashSet<Integer> visited = new HashSet<>();
         HashSet<Integer> complete = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        res = new int[numCourses];
        for(int i=0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            int cur = pre[0];
            int must = pre[1];
            map.get(cur).add(must);
        }
        for(int i=0; i < numCourses; i++){
            if(!complete.contains(i)){
               if(!dfs(i)){
                System.out.println("FAALLLSSEE ");
                return new int[]{};
               }
            }    
        }
        /* n = 3
       [[0,1]]
         0 -> 1
         comp = {1,0}      visite={0}       res ={1,0}
        */
        res = new int[result.size()];
        int l =0;
        for(int n: result){
            res[l++] = n;
        }
        return res;

    }
public boolean dfs(int cou){
    System.out.println("NUM "+cou);
    if(visited.contains(cou)) return false;
   //  if(map.get(cou).isEmpty()) return true;

    visited.add(cou);

    for(int negi: map.get(cou)){
        if(complete.contains(negi)) continue;
        if(!dfs(negi)) return false;
       }
    map.put(cou, new ArrayList<>());
     result.add(cou);
     complete.add(cou);
    visited.remove(cou);
    return true;
    }

    
}
