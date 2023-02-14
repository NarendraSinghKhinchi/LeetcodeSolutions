class Solution {
    public int arrangeCoins(int n) {
        
        int low = 0 ; 
        int high = n;
        int ans = -1 ;
        while(low <= high){
            long mid = low + (high-low)/2 ;
            long required = (mid*(mid+1))/2 ;
            // /System.out.println(mid + "-->" + required);
            if(required > n){
                high = (int) mid-1 ;
            }else{
                ans = (int) mid ;
                low = (int)mid+1 ;
            }
        }
        return ans ;
    }
}