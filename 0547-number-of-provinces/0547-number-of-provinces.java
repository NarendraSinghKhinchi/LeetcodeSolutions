class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int count = 0 ;
        for(int i = 0 ; i < isConnected.length ; i++){
            for(int j = 0 ; j < isConnected.length ; j++){
                if(isConnected[i][j] == 1){
                    count += 1 ;
                    isConnected[i][j] = 0 ;
                    dfs(isConnected , j);
                }
            }
        }
        return count ;
    }
    public void dfs(int [][]isConnected , int i){
        for(int j = 0 ; j < isConnected.length ; j++){
            if(isConnected[i][j] == 1){
                isConnected[i][j] = 0;
                dfs(isConnected , j);
            }
        }
    }
}