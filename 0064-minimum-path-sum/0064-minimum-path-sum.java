class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length] ;
        for(int i = dp.length-1 ; i >= 0 ; i--){
            for(int j = dp[0].length -1 ; j >= 0 ; j--){
                if(i == dp.length-1 && j == dp[0].length - 1){
                    dp[i][j] = grid[i][j] ;
                }else if(j == dp[0].length -1){
                    dp[i][j] = grid[i][j] + dp[i+1][j] ;
                }else if(i == dp.length - 1){
                    dp[i][j] = grid[i][j] + dp[i][j+1] ;
                }else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j] , dp[i][j+1]);
                }
            }
        }
        return dp[0][0] ;
    }
}