class Solution {
    public int getMaximumGold(int[][] grid) {
        // we don't actually require visited here because grid itself has 0 or island for blocking the flow
        // boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] != 0){
                    recurs(grid , i , j , 0);
                }
            }
        }
        return maxGold ;
    }
    int maxGold = 0 ;
    public void recurs(int[][]grid , int row , int col , int gsf){
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0 ){
            maxGold = Math.max(gsf , maxGold);
            return  ;
        }
        
        int gold = grid[row][col] ;
        grid[row][col] = 0 ;
        recurs(grid , row-1 , col , gsf + gold);
        recurs(grid , row+1 , col , gsf + gold);
        recurs(grid , row , col+1 , gsf + gold);
        recurs(grid , row , col-1 , gsf + gold);
        grid[row][col] = gold ;
        
        
    }
}