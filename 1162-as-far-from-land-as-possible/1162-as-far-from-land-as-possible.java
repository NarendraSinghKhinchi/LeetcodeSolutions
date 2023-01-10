class Solution {
    public int maxDistance(int[][] grid) {
        int c = 0 ;
        for(int gr[] : grid){
            for(int i =0 ; i < gr.length ; i++){
                if(gr[i] == 0)gr[i] = Integer.MAX_VALUE - 2 ;
                else c++ ;
            }
        }
        if(c == 0 || c == grid.length  * grid.length )return -1 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
                if(i > 0){
                    grid[i][j] = Math.min(grid[i][j] , grid[i-1][j] + 1) ;
                }
                if(j > 0){
                    grid[i][j] = Math.min(grid[i][j] , grid[i][j-1] + 1) ;
                }
            }
        }
        int max = Integer.MIN_VALUE ;
        for(int i = grid.length - 1 ; i>=0 ; i--){
            for(int j = grid.length - 1 ; j>= 0 ; j--){
                if(i < grid.length - 1){
                    grid[i][j] = Math.min(grid[i][j] , grid[i+1][j]+1);
                }
                if(j < grid.length - 1){
                    grid[i][j] = Math.min(grid[i][j] , grid[i][j+1]+1) ;
                }
                max = Math.max(max , grid[i][j]) ;
            }
        }
        // if(max == Integer.MAX_VALUE - 2)return -1 ;
        return max-1 ;
    }
}




