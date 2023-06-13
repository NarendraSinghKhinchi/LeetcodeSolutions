class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
                if(compare(grid , i , j))count++ ;
            }
        }
        return count ;
    }
    public boolean compare(int [][]grid, int row , int col){
        
        for(int j = 0 ; j < grid.length ; j++){
            if(grid[row][j] != grid[j][col])return false ;
        }
        return true ;
    }
}