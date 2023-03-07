class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long lo = 1 ;
        long ans = -1 ;
        long max = 0l ;
        for(int x : time)max = Math.max(x , max);
        long hi = (long) (totalTrips * max) ;
        
        while(lo <= hi){
            long mid = (lo + hi)/2 ;
            boolean bool = search(time , totalTrips , mid);
            if(bool){
                hi = mid-1 ;
                ans = mid ;
            }else{
                lo = mid+1 ;
            }
        }
        return ans ;
    }
    public boolean search(int []time , int total , long timer){
        
        long count = 0 ;
        for(int bus : time){
            count += (timer/bus) ;
            
            if(count >= total )return true ;
        }
        return false  ;
    }
}