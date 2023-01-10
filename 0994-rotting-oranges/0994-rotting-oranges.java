class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0 ;
        Queue<int []> q = new ArrayDeque<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 2)q.add(new int[] {i , j});
                else if(grid[i][j] == 1)fresh++ ;
            }
        }
        if(fresh == 0)return 0 ;
        int n = grid.length -1 ;
        int m = grid[0].length - 1 ;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int count = -1 ;
        while(q.isEmpty() == false){
            count++ ;
            int size = q.size() ;
            for(int i = 1 ; i <= size ; i++){
                int rot[] = q.poll() ;
                for(int dir[] : dirs){
                    int row = rot[0] + dir[0] ;
                    int col = rot[1] + dir[1] ;
                    if(row < 0 || col < 0 || row > n || col > m || grid[row][col] != 1)continue ;
                    grid[row][col] = 2 ;
                    q.offer(new int[] {row , col});
                    fresh-- ;
                }
            }
        }
        
        return fresh == 0 ? count : -1 ;
    }
}