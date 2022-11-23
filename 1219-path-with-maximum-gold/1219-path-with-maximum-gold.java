class Solution {
    public int getMaximumGold(int[][] grid) {
        
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(visited[i][j] == false && grid[i][j] != 0){
                    recurs(grid , visited , i , j , 0);
                }
            }
        }
        return maxGold ;
    }
    int maxGold = 0 ;
    public void recurs(int[][]grid , boolean[][]visited , int row , int col , int gsf){
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0 || visited[row][col] == true){
            maxGold = Math.max(gsf , maxGold);
            return  ;
        }
        visited[row][col] = true ;
        
        int gold = grid[row][col] ;
        recurs(grid , visited , row-1 , col , gsf + gold);
        recurs(grid , visited , row+1 , col , gsf + gold);
        recurs(grid , visited , row , col+1 , gsf + gold);
        recurs(grid , visited , row , col-1 , gsf + gold);
        
        visited[row][col] = false; 
        
    }
}