class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] =new int[arr.length];
        Arrays.fill(dp , -1);
        int ans = partition(arr , k , 0 , dp);
        return ans ;
    }
    public int partition(int []arr , int k , int idx , int[]dp){
        if(idx == arr.length)return 0 ;
        if(dp[idx] != -1)return dp[idx] ;
        int max = 0 ;
        for(int i = 1 ; i <= k  ; i++){
            int j = idx + i - 1 ;
            if(j >= arr.length)break ;
            
            int ele = (j - idx + 1) ;
            int cmax = maxi(arr , idx , j) * ele;
            int curr = cmax + partition(arr , k ,j+1 , dp );
            max = Math.max(curr , max);
        }
        dp[idx] = max ;
        return max ;
    }
    public int maxi(int arr[] , int i , int j){
        int max = 0 ;
        while(i <= j)max = Math.max(arr[i++] , max);
        return max ;
    }
}