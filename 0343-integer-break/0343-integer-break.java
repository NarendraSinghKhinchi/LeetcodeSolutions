class Solution {
    public int integerBreak(int n) {
        
        int dp[] = new int[n+1];
        Arrays.fill(dp , -1);
        return breaker(n , n-1 , dp) ;
    }
    public int breaker(int n , int idx , int dp[]){
        
        if(n== 0 || idx == 0)return 1 ;
        if(dp[n] != -1)return dp[n] ;
        if(idx > n)return breaker(n , idx-1 , dp);
        int taken = breaker(n-idx , idx , dp) * idx;
        int nottaken = breaker(n , idx-1 , dp);
        
        dp[n] =  Math.max(taken , nottaken);
        return dp[n] ;
    }
}
    
    

