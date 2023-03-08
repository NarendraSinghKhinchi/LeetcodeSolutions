class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length ;
        int m = matrix[0].length;
        int dp[][] = new int[n][m] ;
        
        int ans = 0 ;
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = m-1 ; j >= 0 ; j--){
                dp[i][j] = matrix[i][j] ;
                if(matrix[i][j] == 1 && i < n-1 && j < m-1){
                    dp[i][j] = 1 + Math.min(dp[i][j+1] ,Math.min(dp[i+1][j] , dp[i+1][j+1]) ) ;
                }
               
                ans += dp[i][j] ;
            }
            
        }
        return ans ;
    }
}