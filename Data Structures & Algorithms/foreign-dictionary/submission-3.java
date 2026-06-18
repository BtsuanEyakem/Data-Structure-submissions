class Solution {
    HashMap<Character,List<Character>> map = new HashMap<>();
    HashMap<Character,Boolean> visited = new HashMap<>();
    StringBuilder str = new StringBuilder();
    public String foreignDictionary(String[] words) {

        for(String w: words){
           for(char cr: w.toCharArray()){
              map.putIfAbsent(cr,new ArrayList<>());
           }
        }

        for(int i=1; i< words.length; i++){
            String w1 = words[i-1];
            String w2 = words[i];
            int len = Math.min(w1.length(),w2.length());
            if(w1.substring(0,len).equals(w2.substring(0,len)) && w1.length() > w2.length()) return "";

            for(int j=0; j<len; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    map.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }


        for(char c: map.keySet()){
            if(dfs(c)) return "";
        }
      return str.reverse().toString();
    }
    public boolean dfs(char c){
        if(visited.containsKey(c)) return visited.get(c);

        visited.put(c,true);

        for(char ch: map.getOrDefault(c, new ArrayList<>())){
            if(dfs(ch)) return true;
        }

        str.append(c);
        visited.put(c,false);
        return false;
    }
}

/*
    k->d

    h->{f,c}
    f->d
    k->d->e

    l->n

    
    dk 
*/