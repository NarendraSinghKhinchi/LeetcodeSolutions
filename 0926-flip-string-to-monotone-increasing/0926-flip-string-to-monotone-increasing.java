class Solution {
    public int minFlipsMonoIncr(String s) {
        int dp[] = new int[s.length()+1];
        int num = 0 ;
        for(int i = 1 ; i <= s.length() ; i++){
            if(s.charAt(i-1) == '1'){
                dp[i] = dp[i-1];
                num++ ;
            }else{
                dp[i] = Math.min(num , dp[i-1]+1);
            }
        }
        return dp[s.length()];
    }
}