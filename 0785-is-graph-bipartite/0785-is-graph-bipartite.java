class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[] = new int[graph.length];
        Arrays.fill(visited , -1);
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0 ; i < graph.length ; i++){
            if(visited[i] == -1){
                q.add(new int[]{i , 0});
                visited[i] = 0 ;
                while(!q.isEmpty()){
                    int rem[] = q.remove();
                    for(int nbr : graph[rem[0]]){
                        if(visited[nbr] == -1){
                            visited[nbr] = rem[1] == 0 ? 1 : 0 ;
                            q.add(new int[]{nbr , visited[nbr]});
                        }else if(visited[nbr] == rem[1])return false ;
                    }
                }
            }
        }
        
        
        return true ;
    }
}