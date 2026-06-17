class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0; i < s.length(); i++){
                map.put(s.charAt(i),i);
            }

            int first = 0;
            int last = 0;
            List<Integer> res = new ArrayList<>();
          while(first< s.length()){
            int len = map.get(s.charAt(first));
            last = len;
                for(int i=first; i < last; i++){
                    last = Math.max(last,map.get(s.charAt(i)));
                }
            res.add(last-first+1);
            first = last+1;
            }
        return res;
        
    }
}
