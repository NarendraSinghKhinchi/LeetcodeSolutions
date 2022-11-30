class Solution {
    public int minScoreTriangulation(int[] values) {
        int dp[][] = new int[values.length][values.length] ;
        return recurs(values , 0 , values.length-1 , dp);
    }
    public int recurs(int[]values , int i , int j , int[][] dp ){
        
        if(dp[i][j] != 0)return dp[i][j] ;
        int min = Integer.MAX_VALUE ;
        for(int k = i + 1 ; k < j ; k++){
            int score = values[i] * values[j] * values[k] ;
            score += recurs(values , i ,k , dp) + recurs(values , k , j , dp);
            min = Math.min(min ,score);
        }
        dp[i][j] = min == Integer.MAX_VALUE ? 0 : min ;
        return dp[i][j] ;
    }
}