class KthLargest {
    int kth;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)-> a-b);

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        int i=0; 
        for(int n: nums){
            minHeap.offer(n);
        }
        while(minHeap.size()>kth){
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > kth) minHeap.poll();
        return minHeap.peek();
        
    }
}
