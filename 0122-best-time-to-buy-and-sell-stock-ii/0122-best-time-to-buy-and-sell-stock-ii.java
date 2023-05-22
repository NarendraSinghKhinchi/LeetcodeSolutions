class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int d[] : dp)Arrays.fill(d , -1);
        int profit = recurs(0 , 0 , prices , dp);
        
        return profit ;
    }
    // 0 means you can buy 1 means already bought
    public int recurs(int idx , int buy , int[]prices , int dp[][] ){
        if(idx == prices.length)return 0 ;
        if(dp[idx][buy] != -1)return dp[idx][buy] ;
        int profit = 0 ;
        if(buy == 0){
            profit = Math.max(recurs(idx+1 , 0 , prices , dp) , recurs(idx+1 , 1 , prices , dp)-prices[idx]);
        }else
            profit = Math.max(recurs(idx+1 , 0 , prices , dp) + prices[idx] , recurs(idx+1 , 1 , prices , dp));
        
        dp[idx][buy] = profit ;
        return profit ;
    }
}