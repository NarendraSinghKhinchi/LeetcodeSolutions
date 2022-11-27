class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int dp[] = new int[nums.length] ;
        int sub = 0 ;
        for(int i = 0 ; i < dp.length ; i++){
                int max = 0 ;
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j]){
                    max = Math.max(dp[j] , max);
                }
            }
            dp[i] = max+1 ;
            sub = Math.max(sub , dp[i]) ;
        }
            
        return sub ;
    }
}