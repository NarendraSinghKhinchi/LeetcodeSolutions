class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<Integer> []graph = new ArrayList[roads.length+1] ;
        
        for(int i = 0 ; i<graph.length ;  i++)graph[i] = new ArrayList<>() ;
        for(int road[] : roads){
            graph[road[0]].add(road[1]) ;
            graph[road[1]].add(road[0]) ;
        }
        this.fuel = 0l ;
        dfs(graph , seats , -1 , 0);
        return fuel ;
    }
    long fuel ;
    public long dfs(ArrayList<Integer> graph [] , int seats , int parent , int node){
        
        long rep = 1 ;
        
        for(int adj : graph[node]){
            if(adj != parent){
                rep += dfs(graph , seats , node , adj);
            }
        }
        
        if(node != 0){
            fuel += Math.ceil((double)rep / seats) ;
            
        }
        return rep ;
    }
    
}