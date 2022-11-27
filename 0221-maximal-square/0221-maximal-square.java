class Solution {
    public int maximalSquare(char[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        int max = 0 ;
        for(int i = dp.length - 1 ; i >= 0 ; i--){
            for(int j = dp[0].length - 1 ; j >= 0 ; j--){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0 ;
                    continue ;
                }
                if(i == dp.length - 1){
                    dp[i][j] = matrix[i][j] - '0' ;
                }else if(j == dp[0].length -1){
                    dp[i][j] = matrix[i][j] - '0' ;
                }else{
                    dp[i][j] = Math.min(dp[i+1][j] , Math.min(dp[i][j+1] , dp[i+1][j+1])) + 1;
                }
                max = Math.max(max , dp[i][j]);
                
            }
            
        }
        return max*max ;
    }
}