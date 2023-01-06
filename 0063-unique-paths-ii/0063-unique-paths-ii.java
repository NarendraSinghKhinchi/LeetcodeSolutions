class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length ;
        int n = obstacleGrid[0].length;
        int grid[][] = new int[m][n] ;
        for(int i = m-1 ; i >= 0; i--){
            for(int j = n-1 ; j>= 0 ; j--){
                if(i == m-1 && j == n-1){
                    grid[i][j] = 1 ;
                }else if( j == n-1){
                    grid[i][j] = grid[i+1][j] ;
                }else if(i == m-1){
                    grid[i][j] = grid[i][j+1] ;
                }else{
                    grid[i][j] = grid[i+1][j] + grid[i][j+1] ;
                }
                if(obstacleGrid[i][j] == 1)grid[i][j] = 0 ;
            }
        }
        return grid[0][0] ;
    }
}