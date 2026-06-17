class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] output = new int[queries.length];
        for(int i=0; i < queries.length; i++){
        int q = queries[i];
        int dis = Integer.MAX_VALUE;
            for(int j=0; j < intervals.length; j++){
                int start = intervals[j][0];
                int end = intervals[j][1];
                if(q >= start && q<=end){
                    dis = Math.min(end-start+1,dis);
                }
            }
        output[i] = dis == Integer.MAX_VALUE ? -1: dis;
        }

        return output;

    }
}
