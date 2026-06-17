class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        res.add(intervals[0]);

        for(int i=1; i < intervals.length; i++){
            int lastInterval = res.get(res.size()-1)[1];

            if(intervals[i][0] <= lastInterval){
                res.get(res.size()-1)[1] = Math.max(intervals[i][1],lastInterval);
            }else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
