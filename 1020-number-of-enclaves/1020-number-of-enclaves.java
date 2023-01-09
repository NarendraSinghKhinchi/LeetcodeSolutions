class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0 ;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int row =0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[0].length ; col++){
                if(grid[row][col] == 1 && visited[row][col] == false){
                    boolean found[] = new boolean[1] ;
                    int curr = connect(grid , row , col , visited , found);
                    if(found[0] == false)count += curr ;
                }
            }
        }
        return count ;
    }
    public int connect(int grid[][] , int row , int col , boolean visited[][] , boolean found[] ){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0 )return 0 ;
        
        visited[row][col] = true ;
        int sum = connect(grid , row+1 , col , visited , found);
        sum += connect(grid, row-1 , col , visited , found);
        sum += connect(grid , row , col+1 , visited , found);
        sum += connect(grid, row , col-1 , visited , found);
        
        if(row == 0 || col == 0 || row == grid.length - 1 || col == grid[row].length - 1)found[0] = true ;
        return sum+1 ;
    }
    
}