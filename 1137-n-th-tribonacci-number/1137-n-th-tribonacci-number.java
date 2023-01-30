class Solution {
    public int tribonacci(int n) {
        if(n==0||n==1)return n ;
        int fir = 0 ;
        int sec = 0 ;
        int thr = 1 ;
        for(int i = 2 ; i < n ; i++){
            int curr = fir+sec+thr ;
            fir = sec ;
            sec = thr ;
            thr = curr ;
        }
        return fir+sec+thr ;
    }
}