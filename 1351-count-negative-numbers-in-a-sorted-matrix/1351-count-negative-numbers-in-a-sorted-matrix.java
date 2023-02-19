class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0 ;
        int low = 0 ;
        for(int i = grid.length - 1 ; i >= 0 ; i--){
            for(int j = low ; j < grid[0].length ; j++){
                if(grid[i][j] < 0){
                    count += (grid[0].length - j) ;
                    low = j ;
                    break ;
                }
            }
        }
        return count ;
    }
}