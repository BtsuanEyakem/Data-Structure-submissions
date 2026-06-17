class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int red = 0;
        for(int i=1; i < intervals.length; i++){
            int start = intervals[i][0];
           if(start < res.get(res.size()-1)[1]){
                red++;
            }else{
                res.add(intervals[i]);
            }
        }
        return red;

    }
}
