class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length()+1 ;
        int m = word2.length()+1 ;
        int dp[][] = new int[n][m] ;
        
        for(int i = 1 ; i < n ; i++ ){
            for(int j = 1 ; j < m ; j++){
                char ch1 = word1.charAt(i-1);
                char ch2 = word2.charAt(j-1);
                if(ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        int longest = dp[n-1][m-1];
        return (word1.length()-longest) +( word2.length() - longest) ;
    }
}