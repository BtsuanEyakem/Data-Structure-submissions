class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

       
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i < hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }
         PriorityQueue<Integer> q = new PriorityQueue<>(map.keySet());

         while(!q.isEmpty()){
             int cur = q.peek();

             for(int num = cur; num < cur+groupSize; num++){
                if(!map.containsKey(num)) return false;
                
                map.put(num, map.get(num)-1);
                if(map.get(num) == 0){
                    if(q.peek() != num) return false;
                    map.remove(num);
                    q.poll();
                }
             }
         }

         return true;
        
    }
}
