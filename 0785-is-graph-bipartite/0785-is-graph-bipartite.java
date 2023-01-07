class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Pair> q = new ArrayDeque<>();
        int visited[] = new int[graph.length] ;
        Arrays.fill(visited,-1);
        for(int v = 0 ; v < graph.length ; v++){
            if(visited[v] == -1)
                q.add(new Pair(v,0)) ;
            while(q.size() > 0){
                Pair rem = q.remove();
                if(visited[rem.v] != -1){
                    if(rem.dis != visited[rem.v] )return false ;
                    // else continue ;
                }
                visited[rem.v] = rem.dis ;
                for(int j = 0 ; j < graph[rem.v].length ; j++){
                    if(visited[graph[rem.v][j]] == -1){
                        q.add(new Pair(graph[rem.v][j] , rem.dis+1));
                    }
                }
            }
        }
        return true ;
    }
    private class Pair{
        int v , dis ;
        Pair(int v , int dis){
            this.v = v ;
            this.dis = dis ;
        }
    }
}