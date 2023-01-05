class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)return -1 ;
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            hm.put(i , new ArrayList<>()) ;
        }
        for(int i = 0 ; i < connections.length ; i++){
            hm.get(connections[i][0]).add(connections[i][1]) ;
            hm.get(connections[i][1]).add(connections[i][0]) ;
        }
        System.out.println(hm) ;
        boolean visited[] = new boolean[n] ;
        int count = 0 ; 
        for(int i = 0 ; i < visited.length ; i++){
            if(!visited[i]){
                visited[i] = true ;
                count++ ;
                dfs(hm, visited , i) ;
            }
        }
        return count-1 ;
    }
    public void dfs(HashMap<Integer,ArrayList<Integer>> graph, boolean []visited , int v){
        
        ArrayList<Integer> list = graph.get(v) ;
        for(int x : list){
            if(!visited[x]){
                visited[x] = true ;
                dfs(graph , visited , x) ;
            }
        }
    }
}