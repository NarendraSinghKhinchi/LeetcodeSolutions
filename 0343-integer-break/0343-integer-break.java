class Solution {
    public int integerBreak(int n) {
        
        return breaker(n , n-1) ;
    }
    public int breaker(int n , int idx){
        
        if(n== 0 || idx == 0)return 1 ;
        
        if(idx > n)return breaker(n , idx-1);
        int taken = breaker(n-idx , idx) * idx;
        int nottaken = breaker(n , idx-1);
        
        return Math.max(taken , nottaken);
    }
}
    
    

