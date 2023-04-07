class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length - 1 ;
        int col = grid[0].length - 1 ;
        for(int i = 0 ; i <= col ; i++ ){
            // first row
            if(grid[0][i] == 1){
                dfs(grid , 0 , i);
            } 
            // last row
            if(grid[row][i] == 1){
                dfs(grid , row , i);
            }
        }
        for(int i = 0 ; i <= row ;i++){
            //  first col
            if(grid[i][0] == 1){
                dfs(grid , i , 0);
            }
            // last col
            if(grid[i][col] == 1){
                dfs(grid , i , col);
            }
        }
        int count = 0 ;
        for(int i = 0 ; i <= row ; i++){
            for(int j = 0 ; j <= col ; j++){
                if(grid[i][j] == 1)count++ ;
            }
        }
        return count ;
    }
    public void dfs(int grid[][] , int r , int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1)return ;
        grid[r][c] = 0 ;
        dfs(grid , r+1 , c);
        dfs(grid , r-1 , c);
        dfs(grid , r , c+1);
        dfs(grid , r , c-1) ;
    }
}