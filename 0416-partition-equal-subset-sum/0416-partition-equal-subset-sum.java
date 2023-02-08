class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int x : nums)sum += x ;
        if(sum % 2 != 0)return false ;
        int target = sum/2 ;
        int dp[][] = new int[nums.length][target+1];
        for(int row[] : dp)Arrays.fill(row , -1);
        return recurs(0 , nums , target , dp);
    }
    public boolean recurs(int idx , int nums[] , int target , int dp[][]){
        
        if(target == 0)return true ;
        if(idx >= nums.length || target < 0)return false ;
        if(dp[idx][target] != -1)return dp[idx][target] == 0 ? false : true ;
        
        dp[idx][target] = (recurs(idx+1 , nums , target , dp ) || recurs(idx+1 , nums , target-nums[idx] , dp)) ? 1 : 0;
        
        return dp[idx][target] == 0 ? false : true ;
    }
}