class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr , (a,b)-> a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]) ;
        int dp[] = new int[arr.length] ;
        int maxlen = 0 ;
        for(int i = 0 ; i < dp.length ; i++){
            int index = search(dp , 0 , maxlen , arr[i][1]) ;
            dp[index] = arr[i][1] ;
            if(index == maxlen){
                maxlen++ ;
            }
        }
        return maxlen ;
    }
    public int search(int []dp , int l , int h , int target){
        while(l < h){
            int m = l + (h-l)/2 ;
            if(dp[m] == target)return m ;
            
            if(dp[m] > target){
                h= m ;
            }else{
                l = m+1 ;
            }
        }
        return l ;
    }
}