class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)-> b-a);
        for(int n: stones){
            minHeap.offer(n);
        }
        while(minHeap.size() > 1){
            int big1 = minHeap.poll();
            int big2 = minHeap.poll();
            if(big1-big2 !=0){
                minHeap.offer(big1-big2);
            }
        }

        return minHeap.isEmpty() ? 0 : minHeap.poll();
    }
}
