class Solution {
    public int maxSubArray(int[] nums) {
        
        int dp[] = new int[nums.length+1];
        dp[0] = 0 ;
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= nums.length ; i++){
            // come in previous or start new
            dp[i] = Math.max(dp[i-1]+nums[i-1] , nums[i-1]);
            max = Math.max(max , dp[i]);
        }
        return max ;
    }
}