class Solution {
    public int minInsertions(String s) {
        int dp[][] = new int[s.length()][s.length()] ;
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        int ans = insert(s , 0 , s.length()-1 , dp);
        return ans ;
    }
    public int insert(String s , int i , int j , int dp[][]){
        if(i >= j)return 0 ;
        if(dp[i][j] != -1)return dp[i][j] ;
        char ch = s.charAt(i);
        char ch1 = s.charAt(j);
        
        if(ch == ch1){
            return dp[i][j] = insert(s , i+1 , j-1 ,dp);
        }
        int left = insert(s , i , j-1 , dp) + 1;
        int right = insert(s , i+1 , j , dp) + 1;
        dp[i][j] =  Math.min(left , right);
        return dp[i][j] ;
    }
}