class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length] ;
        Arrays.fill(dp , -1);
        dp[nums.length - 1] = 0 ;
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            int jump = nums[i] ;
            for(int j = 1 ; j <= jump && i+j < nums.length ; j++){
                if(dp[i] == -1 && dp[i+j] != -1){
                    dp[i] = dp[i+j]+1 ;
                }else if(dp[i+j] != -1)
                    dp[i] = Math.min(dp[i] , dp[i+j]+1);
                
            }
        }
        return dp[0];
    }
}