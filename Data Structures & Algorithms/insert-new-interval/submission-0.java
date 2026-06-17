class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
          int[] prior = newInterval;
            List<int[]> res = new ArrayList<>();
            int l =0;
            for(int i=0; i< intervals.length; i++){
                int startP = prior[0];
                int endP = prior[1];
                int startI = intervals[i][0];
                int endI  = intervals[i][1];
                if(endI < startP) {
                    res.add(intervals[i]);
                } else if(endP < startI){
                        res.add(prior);
                        prior = intervals[i];
                }else{
                    prior[0] = Math.min(startI,startP);
                    prior[1] = Math.max(endI,endP);
                }
            }
          
          res.add(prior);
          int[][] solution = res.toArray(new int[res.size()][]);

          return solution;
   
    }
}
