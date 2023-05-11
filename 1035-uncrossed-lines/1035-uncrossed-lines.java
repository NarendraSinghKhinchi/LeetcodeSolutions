class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int dp[][] = new int[nums1.length][nums2.length];
        for(int d[] : dp)Arrays.fill(d ,-1);
        int ans = max(nums1 ,nums2 , 0 , 0 , dp);
        return ans ;
    }
    public int max(int nums[] , int arr[] , int i , int j , int dp[][]){
        if(i == nums.length || j == arr.length )return 0 ;
        if(dp[i][j] != -1)return dp[i][j] ;
        
        int ans = max(nums , arr , i+1 , j , dp) ;
        
        for(int k = j ; k < arr.length ; k++){
            if(arr[k] == nums[i]){
               int co2 = 1 + max(nums , arr , i+1 , k+1 , dp);
               ans = Math.max(ans , co2);
            }
        }
        dp[i][j] = ans ;
        return ans;
    }
}