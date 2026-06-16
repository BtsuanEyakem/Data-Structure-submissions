class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();
        dfs(n,n,n,new StringBuilder(),result);
        return result;
    }

    public void dfs(int open, int cloth, int n, StringBuilder str,List<String> result){
        if(str.length() == n*2){
            result.add(str.toString());
            return;
        }

        if(open > 0){
            str.append("(");
            dfs(open-1,cloth,n,str,result);
            str.deleteCharAt(str.length()-1);
            
        } 
        if(cloth > open){
            str.append(")");
            dfs(open,cloth-1,n,str,result);
            str.deleteCharAt(str.length()-1);
        }

    }
}
