class Solution {
    public double myPow(double x, int n) {
        if((n>=Integer.MAX_VALUE || n<=Integer.MIN_VALUE) && x>1)
            return 0;
        if(n == 0)return 1 ;
       boolean bool = false ;
       if(n < 0){
           n = -n ;
           bool = true ;
       }
       double ans = myPow(x , n/2);
       ans = ans*ans ;
       if(n%2 != 0){
           ans *= x ;
       }
       if(bool){
           return 1/ans ;
       }
       return ans ;
    }
}
