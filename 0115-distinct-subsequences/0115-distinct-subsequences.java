class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()] ;
        for(int row[] : dp)Arrays.fill(row , -1);
        return recurs(s.length() - 1 , t.length() - 1 , s , t , dp);
    }
    public int recurs(int i , int j , String s , String t , int dp[][]){
        if(j < 0)return 1 ;
        if(i < 0)return 0 ;
        if(dp[i][j] != -1)return dp[i][j] ;
        int ans = recurs(i-1 , j , s , t , dp);
        if(s.charAt(i) == t.charAt(j))
            ans += recurs(i-1 , j-1 , s , t , dp) ;
        dp[i][j] = ans; 
        return ans  ;
    }
}