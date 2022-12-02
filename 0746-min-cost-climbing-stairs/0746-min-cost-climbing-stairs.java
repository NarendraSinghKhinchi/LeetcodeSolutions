class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length] ;
        dp[dp.length-1] = cost[cost.length-1] ;
        for(int i = dp.length - 2 ; i >= 0 ; i--){
            if(i == dp.length - 2){
                dp[i] = cost[i] ;
            }else{
                dp[i] = cost[i] + Math.min(dp[i+1] , dp[i+2]) ;
            }
        }
            
        
        
        return Math.min(dp[0] , dp[1]) ;
    }
}