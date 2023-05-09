class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        long sum = 0l ;
        for(int x : candies)sum += x ;
        long left = 1l ;
        long right = sum ;
        long ans = 0 ;
        
        while(left <= right){
            long mid = left + (right-left)/2 ;
            if(satisfy(candies , k , mid)){
                ans = mid ;
                left = mid+1 ;
            }else right = mid-1 ;
        }
        return (int) ans ;
    }
    public boolean satisfy(int candies[] , long k , long curr){
        
        long ks = 0 ;
        for(int x : candies){
            // if(x % curr >= curr ){
                ks += x/curr ;
            // }
                
        }
        if(ks < k)return false ;
        return true ;
    }
}