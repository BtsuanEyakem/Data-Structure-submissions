class Twitter {

    HashMap<Integer,HashSet<Integer>> follow;
    TwitteNode head;
	TwitteNode tail;

	 public Twitter(){
	 	follow = new HashMap<>();
		head = new TwitteNode();
		tail = new TwitteNode();
		head.next = tail;
		tail.prev = head;
 	}

    
    public void postTweet(int userId, int tweetId) {
    	TwitteNode node = new TwitteNode(userId,tweetId);
		addTwitte(node);
    }

    
    public List<Integer> getNewsFeed(int userId) {
    
		List<Integer> res = new ArrayList<>();
		TwitteNode curr = head.next;
       
		HashSet<Integer> followersOf = follow.get(userId);
		while(res.size() < 10 && curr != tail){
			if((followersOf != null && followersOf.contains(curr.userId)) || userId == curr.userId){
			     res.add(curr.tweetId);
              }
              curr = curr.next;
        }

        return res;
    }
    
    public void addTwitte(TwitteNode node){
		TwitteNode curr = head.next;
		head.next = node;
	 	node.next = curr;
		curr.prev = node;
		node.prev = head;

    }


    
    public void follow(int followerId, int followeeId) {
      follow.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }

    
    public void unfollow(int followerId, int followeeId) {
        follow.get(followerId).remove(followeeId);
    }
}
    class TwitteNode {
        int userId;
        int tweetId;
        TwitteNode next;
        TwitteNode prev;

        public TwitteNode(){}
        public TwitteNode(int user, int tweetId){
                this.userId = user;
                this.tweetId = tweetId;
        }
    }

