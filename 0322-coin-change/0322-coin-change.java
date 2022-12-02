class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0 ;
        Integer dp[] = new Integer[amount+1] ;
        dp[0] = 0 ;
        for(int i = 1 ; i <= amount ; i++){
            for(int j = 0 ; j < coins.length ; j++){
                int coin = coins[j] ;
                if(coin <= i && dp[i-coin] != null){
                    if(dp[i] == null){
                        dp[i] = dp[i-coin] + 1 ;
                    }else{
                        dp[i] = Math.min(dp[i] , dp[i-coin] + 1);
                    }
                }
            }
        }
        if(dp[amount] == null)return -1;
        return dp[amount] ;
    }
}