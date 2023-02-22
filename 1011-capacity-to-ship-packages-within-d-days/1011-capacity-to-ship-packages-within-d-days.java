class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // max element that can be found in  array is 500 
        int sum = 0 ;
        for(int wei : weights)sum += wei ;
        int min = 1 ;
        int max =  sum ;
        int ans = -1 ;
        while(min <= max){
            int mid = (min+max)/2 ;
            boolean bool = binary(weights , mid , days) ;
            if(bool){
                ans = mid ;
                
                max = mid-1 ;
            }else{
                min = mid+1 ;
            }
        }
        return ans ;
    }
    public boolean binary(int weights[] , int capacity , int days){
        
        int cdays = 1 ;
        int cwei = 0 ;
        for(int wei : weights){
            if(cwei+wei <= capacity){
                cwei = cwei+wei ;
            }else{
                cwei = wei ;
                cdays += 1 ;
            }
            if(cdays > days || wei > capacity)return false ;
        }
        
        return true ;
    }
}