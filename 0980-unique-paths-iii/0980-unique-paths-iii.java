class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zero = 0 ;
        int strow = -1 ;
        int stcol = -1 ;
        int destrow = -1 ;
        int destcol = -1 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 0)zero++ ;
                else if(grid[i][j] == 1){
                    strow = i ;
                    stcol = j ;
                }else if(grid[i][j] == 2){
                    destrow = i ;
                    destcol = j ;
                }
            }
        }
        this.count = 0 ;
        this.zeroes = zero ;
        boolean visited[][] = new boolean[grid.length][grid[0].length] ;
        dfs(grid , visited , strow , stcol , destrow , destcol , 0);
        return count ;
    }
    int zeroes = 0 ;
    public void dfs(int[][]grid , boolean visited[][] , int row , int col , int destrow , int destcol , int zsf){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] == true || grid[row][col] == -1 ){
            return ;
        }
        if(row == destrow && col == destcol && zsf == zeroes){
            count++ ;
        }
        visited[row][col] = true ;
        if(grid[row][col] == 0)zsf++ ;
        dfs(grid , visited , row+1 , col , destrow , destcol , zsf);
        dfs(grid , visited , row-1 , col , destrow , destcol , zsf);
        dfs(grid , visited , row , col+1 , destrow , destcol , zsf);
        dfs(grid , visited , row , col-1 , destrow , destcol , zsf);
        
        visited[row][col] = false ;
    }
    int count = 0 ;
}