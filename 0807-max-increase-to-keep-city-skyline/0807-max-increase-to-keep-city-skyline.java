class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length ;
        int cols[] = new int[n];
        // int right[] = new int[n];
        int rows[] = new int[n];
        // int bottom[] = new int[n];
        
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < n ; j++){
                int m = grid[i][j] ;
                
                rows[i] = Math.max(rows[i],m);
                cols[j] = Math.max(cols[j],m);
            }
        }
        int sum = 0;
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < n ; j++){
                int m = grid[i][j] ;
                int max = Math.min(rows[i],cols[j]);
                sum += max-m ;
            }
        }
        return sum ;
    }
}