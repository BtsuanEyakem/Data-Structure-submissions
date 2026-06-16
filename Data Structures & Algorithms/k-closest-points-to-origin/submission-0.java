class Solution {
    public int[][] kClosest(int[][] points, int k) {
      PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b)->Double.compare(b[2],a[2]));




        for(int[] point: points){
            double x = point[0];
            double y = point[1];
            double res = Math.sqrt((x*x)+(y*y));
            maxHeap.offer(new double[]{x,y,res});
            if(maxHeap.size() > k) maxHeap.poll(); 
        }
        int[][] res = new int[k][2];
        int i=0;

        for(double[] q: maxHeap){
            int x = (int) q[0];
            int y =(int) q[1];
            res[i++] = new int[]{x,y};
        }
        return res;
    }
}
