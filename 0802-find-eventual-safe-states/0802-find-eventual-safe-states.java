class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> list = new ArrayList<>();
            // going to check every single node/state if it is safe or not
        int colors[] = new int[graph.length];
        for(int i = 0 ; i < graph.length ; i++){
            if(safe(graph , i , colors))list.add(i);
        }
        return list ;
    }
    public boolean safe(int graph[][] , int v , int []colors){
        // 0 means not visited by dfs
        // 1 means visited by dfs and it is not safe 
        // 2 means visited by dfs and it is safe
        // 3 means visited by dfs and it is not safe
        if(colors[v] == 1 || colors[v] == 3)return false ;
        if(colors[v] == 2)return true ;
        colors[v] = 1 ;
        for(int nbr : graph[v]){
            if(!safe(graph , nbr , colors)){
                colors[nbr] = 3 ;
                return false ;
            }
        }
        colors[v] = 2 ;
        return true ;
    }
}