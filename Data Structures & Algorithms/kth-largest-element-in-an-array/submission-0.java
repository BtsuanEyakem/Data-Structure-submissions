class Solution {
    public int findKthLargest(int[] nums, int k) {
       //  if(k > nums.size()) return 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n: nums){
            minHeap.offer(n);
            if(minHeap.size() > k) minHeap.poll();
        } 
        return minHeap.peek();
    }
}

// TC = O(nlogn)
