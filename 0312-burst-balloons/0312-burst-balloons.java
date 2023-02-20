class Solution {
    public int maxCoins(int[] nums) {
        int dp[][] = new int[nums.length][nums.length] ;
        for(int row []:dp )Arrays.fill(row , -1);
        return burst(nums , 0, nums.length-1 , dp);
    }
    public int burst(int []nums , int i , int j , int dp[][]){
        if(i > j)return 0 ;
        // if(i == j)return nums[i] ;
        // System.out.println(i + "-->" + j);
        if(dp[i][j] != -1)return dp[i][j] ;
        int max = 0 ;
        for(int k = i ; k <= j; k++){
            int mul = nums[k] ;
            if(i >= 1) mul *= nums[i-1] ;
            if(j < nums.length-1 ) mul *= nums[j+1] ;
            
            int curr = burst(nums , i , k-1 , dp ) + burst(nums , k+1 , j ,dp ) + mul ;
            max = Math.max(curr , max);
        }
        dp[i][j] = max ;
        return max ;
    }
}


