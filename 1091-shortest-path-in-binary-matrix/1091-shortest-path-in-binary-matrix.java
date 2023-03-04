class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
        
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)return -1 ;
        int len = 0 ;
        
        Queue<int[]> q = new ArrayDeque<>();
        int dirs[][] = new int[][]{{1,0} , {1,-1} , {1 , 1} , {-1 , 0} , {-1 , 1} , {-1 , -1} , {0 , 1} , {0 , -1}};
        
        q.add(new int[]{0 , 0});
        boolean visited[][] = new boolean[n][m] ;
        visited[0][0] = true ;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int rem[] = q.remove();
                int i = rem[0] ;
                int j = rem[1] ;
                if(i == n-1 && j == m-1)return len+1 ;
                
                
                for(int dir[] : dirs){
                    int x = dir[0] + i ;
                    int y = dir[1] + j ;
                    // if(x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && grid[x][y] == 0 ){
                    //     q.add(new int[]{x , y});
                    //     visited[x][y] = true ;
                    // }
                    if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || grid[x][y] == 1)continue ;
                        q.add(new int[]{x , y});
                        visited[x][y] = true ;
                }
            }
            len++ ;
        }
        return -1 ;
    }
}



