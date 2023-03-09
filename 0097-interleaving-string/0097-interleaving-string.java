class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())return false ;
        int dp[][][] = new int[s3.length()][s3.length()][s3.length()] ;
        boolean flag = recurs(s1 , s2 , s3 , 0 , 0 , 0 , dp);
        return flag ;
    }
    public boolean recurs(String s1 , String s2 , String s3 , int i , int j , int k , int dp[][][]){
        if(k == s3.length())return true ;
        if(i == s1.length() && j == s2.length())return false ;
        if(dp[i][j][k] != 0)return dp[i][j][k] == 1 ;
        
        boolean left = false ;
        boolean right = false ;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            left  = recurs(s1 , s2 , s3 , i+1 , j , k+1 , dp);
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            right = recurs(s1 , s2 , s3 , i , j+1 , k+1 , dp);
        }
        
        boolean ans =  left || right ;
        dp[i][j][k] = ans ? 1 : 2 ;
        return ans ;
    }
}