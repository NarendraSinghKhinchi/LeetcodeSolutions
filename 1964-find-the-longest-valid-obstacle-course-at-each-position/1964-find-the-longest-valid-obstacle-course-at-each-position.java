class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        
        int dp[] = new int[obstacles.length];
        int lis[] = new int[obstacles.length];
        int lastIdx = 0 ;
        for(int i = 0 ; i < dp.length ; i++){
            // dp[i] = 1 ;
//             for(int j = i-1 ; j >= 0 ; j--){
//                 if(obstacles[j] <= obstacles[i]){
//                     dp[i] = Math.max(dp[i] , 1+dp[j]);
                    
//                 }
//             }
            int player = obstacles[i] ;
            int idx = helper(lis , player , lastIdx);
            
            if(idx == lastIdx){
                lastIdx++ ;
            }
            
            lis[idx] = player ;
            dp[i] = idx+1;
        }
        return dp ;
    }
    public int helper(int []lis , int tar , int right){
        if(right == 0)return 0 ;
        int left = 0 ;
        while(left < right){
            int mid = left + (right-left)/2 ;
            if(lis[mid] <= tar)left = mid + 1 ;
            else right = mid ;
        }
        return right ;
    }
}