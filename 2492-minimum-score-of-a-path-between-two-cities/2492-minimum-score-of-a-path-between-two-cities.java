class Solution {
    public int minScore(int n, int[][] roads) {
        
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            list.add(new ArrayList<>());
        }
        for(int road[] : roads){
            int i = road[0];
            int j = road[1];
            int w = road[2];
            
            list.get(i).add(new int[]{j , w});
            list.get(j).add(new int[]{i , w});
        }
        int min = Integer.MAX_VALUE ;
        boolean visited[] = new boolean[n+1] ;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        
        while(!q.isEmpty()){
            int rem = q.remove();
            
            visited[rem] = true ;
            for(int []nbr : list.get(rem)){
                min = Math.min(nbr[1] , min);
                if(visited[nbr[0]] == false)q.add(nbr[0]);
            }
        }
        return min ;
    }
    
}
















// int grid[][] = new int[n+1][n+1] ;
//         for(int gr[] : grid)Arrays.fill(gr , -1);
//         for(int road[] : roads){
//             grid[road[0]][road[1]] = road[2];
//             grid[road[1]][road[0]] = road[2] ;
//         }
//         for(int i = 1 ; i <= n ; i++)grid[i][i] = 0 ;
        
//         for(int k = 1 ; k <= n ; k++){
//             for(int i = 1 ; i <= n ;i++){
//                 for(int j = 1 ;j <= n ; j++){
//                     if(grid[i][k] == -1 || grid[k][j] == -1)continue ;
//                     if(grid[i][j] == -1 || (grid[i][j] > grid[i][k] + grid[k][j]))
//                         grid[i][j] = grid[i][k] + grid[k][j] ;
//                 }
//             }
//         }
//         return grid[1][n] ;