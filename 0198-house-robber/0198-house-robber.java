class Solution {
    public int rob(int[] nums) {

        int dp[] = new int[nums.length+1] ;
        dp[1] = nums[0] ;
        for(int i = 2 ; i <= nums.length ; i++){
            int curr = nums[i-1] ;
            dp[i] = Math.max(dp[i-1] , curr+dp[i-2]) ;
        }
        return dp[nums.length] ;
    }
}