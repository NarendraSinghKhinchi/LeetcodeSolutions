class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        // boolean visited[] = new boolean[graph.length] ;
        // not required because given is directed acyclic cycle
        List<List<Integer>> and = new ArrayList<>() ;
        List<Integer> path = new ArrayList<>() ;
        path.add(0);
        pathfinder(path , graph , and , 0) ;
        return and ;
    }
    public void pathfinder(List<Integer> path , int[][]graph , List<List<Integer>>  ans , int node){
        if(node == graph.length - 1){
            List<Integer> list = new ArrayList<>(path) ;
            // list.add(node) ;
            ans.add(list) ;
            return ;
        }
        // if(visited[node])return ;
        // visited[node] = true ;
        for(int i = 0 ; i < graph[node].length ; i++){
            int next = graph[node][i] ;
            path.add(next) ;
            pathfinder(path , graph , ans , next) ;
            path.remove(path.size() - 1) ;
        }
        // visited[node] = false ;
    }
}