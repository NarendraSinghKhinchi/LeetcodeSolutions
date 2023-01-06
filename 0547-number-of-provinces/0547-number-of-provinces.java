class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0 ;
        boolean visited[] = new boolean[isConnected.length] ;
        for(int i = 0 ; i < isConnected.length ; i++){
            for(int j = 0 ; j < isConnected[0].length ; j++){
                if(isConnected[i][j] == 1 ){
                    isConnected[i][j] = 0 ;
                    count++ ;
                    dfs(isConnected ,j , visited);
                }
            }
        }
        return count ;
    }
    public void dfs(int [][] graph , int i , boolean []visited ){
        if(visited[i])return ;
        for(int j = 0 ; j < graph[i].length ; j++ ){
            if(graph[i][j] == 1){
                graph[i][j] = 0 ;
                dfs(graph , j , visited) ;
            }
        }
        visited[i] = true ;
    }
}
