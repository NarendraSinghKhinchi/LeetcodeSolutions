class Solution {
    public int numDecodings(String s) {
        
        if(s.charAt(0) - '0' == 0)return 0 ;
        int dp[] = new int[s.length() + 1] ;
        dp[0] = 1 ;
        dp[1] = 1 ;
        for(int i = 2 ; i < dp.length ; i++){
            int ch = s.charAt(i-1) - '0' ;
            if(ch != 0){
               dp[i] = dp[i-1] ; 
            }
            int ch2 = s.charAt(i-2) - '0' ;
            if(ch2 == 1 || (ch2 == 2 && ch < 7)){
                dp[i] += dp[i-2] ;
            }
        }
        return dp[s.length()] ;
    }
}