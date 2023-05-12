class Solution {
    public long mostPoints(int[][] questions) {
        
        long dp[][] = new long[questions.length][2];
        //0 the do and 1 skip compulsory
        dp[questions.length-1][0] = questions[questions.length-1][0];
        dp[questions.length-1][1] = 0;
        
        for(int i = questions.length-2 ; i >= 0 ; i--){
            dp[i][0] = questions[i][0];
            dp[i][1] = Math.max(dp[i+1][0] , dp[i+1][1]);
            int nextIdx = i + questions[i][1] + 1 ;
            if(nextIdx < questions.length ){
                dp[i][0] += Math.max(dp[nextIdx][0] , dp[nextIdx][1]);
            }
        }
        return Math.max(dp[0][0] , dp[0][1]);
    }
}