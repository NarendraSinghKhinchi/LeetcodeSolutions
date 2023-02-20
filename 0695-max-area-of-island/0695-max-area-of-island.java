class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    int curr = recurs(grid , i , j);
                    max = Math.max(curr , max);
                }
            }
        }
        
        return max ;
    }
    public int recurs(int grid[][] , int sr , int sc ){
        if(sr < 0 || sc < 0 || sr == grid.length || sc == grid[0].length || grid[sr][sc] == 0)return 0 ;
        
        grid[sr][sc] = 0 ;
        
        int curr = 1 ;
        curr += recurs(grid , sr+1 , sc );
        curr += recurs(grid , sr-1 , sc );
        curr += recurs(grid , sr , sc+1 );
        curr += recurs(grid , sr , sc-1 );
        return curr ;
    }
}