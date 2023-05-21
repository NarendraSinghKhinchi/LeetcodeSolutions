class Solution {
    public int shortestBridge(int[][] grid) {
        this.q = new ArrayDeque<>();
        for(int i = 0 ; i < grid.length ; i++){
            boolean flag = false ;
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    dfs(grid , i , j );
                    flag = true ;
                    break ;
                }
            }
            if(flag)break ;
        }
        int count = 0 ;
        int dirs[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            count++ ;
            
            int size = q.size();
            for(int i = 1 ; i <= size ; i++){
                int rem[] = q.remove();
                for(int dir[] : dirs){
                    int nr = rem[0]+dir[0] ;
                    int nc = rem[1]+dir[1] ;
                    if(nr < 0 || nc < 0 || nr == grid.length || nc == grid[0].length || grid[nr][nc] == 2 )continue ;
                    if(grid[nr][nc] == 1)return count-1 ;
                    grid[nr][nc] = 2 ;
                    q.add(new int[]{nr , nc});
                }
            }
        }
        
        return -1;
    }
    Queue<int[]> q ;
    public void dfs(int [][] grid , int i , int j ){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length  || grid[i][j] != 1)return ;
        
        
        grid[i][j] = 2 ;
        q.add(new int[]{i , j});
        
        dfs(grid , i+1 , j );
        dfs(grid , i-1 , j );
        dfs(grid , i , j+1 );
        dfs(grid, i , j-1 );
    }
}