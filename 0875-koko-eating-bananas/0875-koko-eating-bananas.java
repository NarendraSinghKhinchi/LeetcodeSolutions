class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0 ;
        for(int x : piles)max = Math.max(x , max);
        int lo = 1 ;
        int hi = max ;
        int ans = -1 ;
        while(lo <= hi){
            int k = lo + (hi-lo)/2 ;
            boolean bool = search(piles , h , k);
            if(bool){
                hi = k-1 ;
                ans = k ;
            }else lo = k+1 ;
        }
        return ans ;
    }
    public boolean search(int []piles , int h , int k){
        int hours = 0 ;
        
        for(int banana : piles){
            if(banana != 0){
                int rem = banana % k ;
                hours += (banana/k) + (rem == 0 ? 0 : 1) ;
            }
            if(hours > h)return false ;
        }
        
        return true ;
    }
}