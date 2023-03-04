class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length ;
        int m = maze[0].length ;
        
        int sr = entrance[0] ;
        int sc = entrance[1] ;
        boolean visited[][] = new boolean[n][m] ;
        visited[sr][sc] = true ;
        
        int steps = 0 ;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr , sc});
        int dirs[][] = new int[][]{{1,0} , {-1, 0} , {0 , 1} , {0 , -1}};
        while(q.isEmpty() == false){
            int size = q.size();
            while(size-- > 0){
                int rem[] = q.remove();
                int i = rem[0] ;
                int j = rem[1] ;
                if((i != sr || j != sc) && isexit(i , j , n , m ))return steps ;
                
                for(int dir[] : dirs){
                    int x = i+dir[0] ; 
                    int y = j + dir[1] ;
                    if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || maze[x][y] == '+')continue  ;
                    
                    q.add(new int[]{x , y});
                    visited[x][y] = true ;
                }
            }
            steps++ ;
        }
        return -1 ;
    }
    public boolean isexit(int i , int j , int n , int m ){
        
        if(i == 0 || j == 0 || i == n-1 || j == m-1)return true ;
        return false ;
    }
}