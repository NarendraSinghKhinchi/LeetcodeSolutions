class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 0){
                    boolean bool = dfs(grid , i , j);
                    if(bool)count += 1 ;
                }
            }
        }
        return count ;
    }
    public boolean dfs(int [][]grid , int sr , int sc ){
        if(sr < 0 || sc < 0 || sr == grid.length || sc == grid[0].length )return false ;
        if(grid[sr][sc] == 1 || grid[sr][sc] == -1)return true ;
        grid[sr][sc] = -1 ;
        
        boolean up = dfs(grid , sr+1 , sc);
        boolean down = dfs(grid , sr-1 , sc);
        boolean left = dfs(grid , sr , sc+1);
        boolean right = dfs(grid , sr , sc-1);
        
        return (up && down && right && left) ;
    }
}