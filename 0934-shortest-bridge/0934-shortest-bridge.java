class Solution {
    public int shortestBridge(int[][] grid) {
        this.q = new ArrayDeque<>() ;
        boolean visited[][] = new boolean[grid.length][grid.length];
        for(int i = 0 ; i < grid.length ; i++){
            boolean b = false ;
            for(int j = 0 ; j < grid.length ; j++){
                if(grid[i][j] == 1){
                    dfs(grid , i , j , visited);
                    b = true ;
                    break ;
                }
            }
            if(b)break ;
        }
        // visited = null ;
        // System.out.println(q);
        int count = 0 ;
        int dirs[][] = {{1,0} , {0,1} , {-1,0} , {0,-1}};
        while(q.size() > 0){
            count++ ;
            int size = q.size() ;
            for(int i = 1 ; i <= size ; i++){
                int rem[] = q.remove();
                for(int dir[] :dirs ){
                    int ro = rem[0] + dir[0] ;
                    int co = rem[1] + dir[1] ;
                    if(ro < 0 || co < 0 || ro >= grid.length || co >= grid.length || grid[ro][co] == 2)continue ;
                    if(grid[ro][co] == 1)return count-1 ;
                    grid[ro][co] = 2 ;
                    q.add(new int[]{ro , co}) ;
                }
                // System.out.println(q);
            }
        }
        return -1 ;
    }
    Queue<int[]> q ;
    public void dfs(int [][] grid , int i , int j , boolean visited[][]){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length  || visited[i][j] || grid[i][j] != 1)return ;
        
        visited[i][j] = true ;
        grid[i][j] = 2 ;
        q.add(new int[]{i , j});
        
        dfs(grid , i+1 , j , visited);
        dfs(grid , i-1 , j , visited);
        dfs(grid , i , j+1 , visited);
        dfs(grid, i , j-1 , visited);
    }
}