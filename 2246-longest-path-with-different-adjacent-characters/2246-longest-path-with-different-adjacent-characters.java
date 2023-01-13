class Solution {
    public int longestPath(int[] parent, String s) {
        ArrayList<Integer> tree[] = new ArrayList[parent.length] ;
        for(int i = 0 ; i < parent.length; i++)tree[i] = new ArrayList<>();
        
        for(int i = 1 ; i < parent.length ; i++){
            // tree[i].add(parent[i]);
            tree[parent[i]].add(i) ;
        }
        this.max = 0 ;
        dfs(tree , s , 0 , -1);
        return max ;
    }
    int max = 0 ;
    public int dfs(ArrayList<Integer> tree[] ,String s , int v , int parent ){
        
        int first = 0 ;
        int second = 0 ;
        for(int x : tree[v]){
            if(x != parent){
            int nxt = dfs(tree  , s , x , v);
            if(s.charAt(x) != s.charAt(v)){
                if(nxt > first){
                    second = first ;
                    first = nxt ;
                }else if(nxt > second){
                    second = nxt ;
                }
            }
            }
        }
        
        max = Math.max(max , first + second + 1);
        
        return first+1 ;
    }
}