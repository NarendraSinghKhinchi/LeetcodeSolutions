class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>() ;
        for(int i = 0 ; i < n ; i++)hm.put(i , new ArrayList<>()) ;
        for(int edge[] : edges){
            hm.get(edge[0]).add(edge[1]) ;
            hm.get(edge[1]).add(edge[0]) ;
        }
        boolean visited[] = new boolean[n] ;
        return dfs(hm , source , destination , visited);
    }
    public boolean dfs(HashMap<Integer,ArrayList<Integer>> hm  , int src , int dest , boolean visited[]){
        if(src == dest)return true ;
        
        ArrayList<Integer> nbr = hm.get(src) ;
        for(int nibr : nbr){
            if(!visited[nibr]){
                visited[nibr]=true ;
                boolean bool = dfs(hm , nibr , dest ,visited );
                if(bool)return true ;
                // visited[nibr]= false ;
            }
        }
        return false ;
    }
}