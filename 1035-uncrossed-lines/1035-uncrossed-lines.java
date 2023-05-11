class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int dp[][] = new int[nums1.length+1][nums2.length+1];
        int ans = 0 ;
        for(int i = nums1.length-1 ; i >= 0 ; i--){
            for(int j = nums2.length-1 ; j >= 0 ; j--){
                
                if(nums1[i] == nums2[j]){
                    dp[i][j] = 1 + dp[i+1][j+1] ;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j+1]) ;
                }
                
            }
        }
        
        // for(int d[] : dp)Arrays.fill(d ,-1);
        // int ans = max(nums1 ,nums2 , 0 , 0 , dp);
        
        return dp[0][0] ;
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