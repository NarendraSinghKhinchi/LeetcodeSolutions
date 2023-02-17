class Solution {
    public boolean judgeSquareSum(int c) {
        
        for(long i = 0 ; i*i <= c ; i++){
            long low = 0 ;
            long high = c ;
            while(low <= high){
                long mid = low + (high-low)/2 ;
                long mul = (i*i) + (mid*mid) ;
                if(mul == c)return true ;
                if(mul < c)low = mid+1 ;
                else high = mid-1 ;
            }
        }
        return false ;
    }
}