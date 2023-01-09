class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        dfs(grid , row , col , color , grid[row][col] , visited) ;
        return grid ;
    }
    public void dfs(int [][] grid , int row , int col , int color , int val ,boolean visited[][]){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] != val || visited[row][col]){
            return ;
        }
        visited[row][col] = true ;
        boolean bord = ami(grid , row , col , val);
        
        dfs(grid , row+1 , col , color , val , visited);
        dfs(grid , row-1 , col , color, val , visited);
        dfs(grid , row , col+1 , color , val , visited);
        dfs(grid, row , col-1 , color , val , visited);
        
        if(bord)grid[row][col] = color ;
    }
    public boolean ami(int [][] grid , int row , int col , int val){
        if(row == 0 || col == 0 || row == grid.length-1 || col == grid[row].length - 1)return true ;
        
        if(row - 1 >= 0 && grid[row-1][col] != val )return true ;
        if(col - 1 >=0  && grid[row][col-1] != val)return true ;
        if(row + 1 < grid.length && grid[row+1][col] != val)return true ;
        if(col + 1 < grid[0].length && grid[row][col+1] != val)return true ;
        
        return false ;
    }
}