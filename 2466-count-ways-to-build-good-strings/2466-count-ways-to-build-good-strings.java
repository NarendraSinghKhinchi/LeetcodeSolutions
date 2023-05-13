class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.dp = new int[high+1];
        Arrays.fill(dp,-1);
        int ans = count(low , high , zero , one , 0);
        return ans ;
    }
    int dp[] ;
    int mod = (int)1e9+7 ;
    public int count(int low , int high , int zero , int one , int len){
        if(len > high)return 0 ;
        if(dp[len] != -1)return dp[len];
        int count = count(low , high , zero , one ,len+zero);
        count += count(low , high , zero , one , len+one);
        if(len >= low && len <= high)count += 1 ;
        dp[len] = count%mod ;
        return count%mod ;
    }
}