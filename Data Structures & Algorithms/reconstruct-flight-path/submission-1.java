class Solution {
     HashMap<String, PriorityQueue<String>> store = new HashMap<>();
     List<String> res = new ArrayList<>();
     int len =0;
    public List<String> findItinerary(List<List<String>> tickets) {
        
        for(List<String> ticket: tickets){
		    store.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(res);
        
        return res;
        
    }
    // {jfk,neg,jfk,}
    public void dfs(String orign){

        PriorityQueue<String> negi = store.get(orign);
        while(negi!= null && !negi.isEmpty()){
            String cur = negi.poll();
            dfs(cur);
        }
        res.add(orign);

    }
}

// TC = O(E)^2
//SC O(E)