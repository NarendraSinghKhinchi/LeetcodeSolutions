class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = reverse(s);
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 1 ; i <= m ; i++ ){
            for(int j = 1 ; j <= n ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1 ; i >= 0  ;i--)sb.append(s.charAt(i));
        return sb.toString();
    }
}