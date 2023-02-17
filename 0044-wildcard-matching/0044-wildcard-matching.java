class Solution {
    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()] ;
        for(int row[] : dp)Arrays.fill(row , -1) ;
        return recurs(s , p , s.length()-1 , p.length() - 1 , dp) ;
    }
    public boolean recurs(String s , String p , int i , int j , int dp[][]){
        
        if(i < 0 ){
            while(j >=  0 && p.charAt(j) == '*' )j-- ;
        }
        if(i < 0 && j < 0)return true ;
        
        if(i < 0 || j < 0) return false ;
        
        if(dp[i][j] != -1)return dp[i][j] == 1 ? true : false ;
        
        if(s.charAt(i) == p.charAt(j)){
            dp[i][j]  =  recurs(s , p , i-1 , j-1 , dp) ? 1 : 0 ;
            return dp[i][j] == 1 ? true : false ;
        }
        if(p.charAt(j) == '?'){
            dp[i][j] = recurs(s , p , i-1 , j-1 , dp) ? 1 : 0 ;
            return dp[i][j] == 1 ? true : false ;
        }
        
        if(p.charAt(j) == '*'){
            for(int k = 0 ; k <= i+1 ; k++){
                dp[i][j]  =  recurs(s , p , i-k , j-1 , dp) ? 1 : 0 ;
                if(dp[i][j] == 1)return true ;
            }
        } 
        dp[i][j] = 0 ;
        return false ;
    }
    
}