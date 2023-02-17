class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()] ;
        for(int row[] : dp)Arrays.fill(row , -1) ; 
        return recurs(word1 , word2  , word1.length() - 1 , word2.length() - 1 , dp);
    }
    // word1 --> word2
    public int recurs(String word1 , String word2 , int i , int j , int dp[][]){
        if(j < 0)return i+1 ;
        if(i < 0)return j+1 ;
        if(dp[i][j] != -1)return dp[i][j] ;
        if(word1.charAt(i) == word2.charAt(j)){
            return recurs(word1 , word2 , i-1 , j-1 , dp) ;
        }
        // insert
        int insert = recurs(word1 , word2 , i , j-1 , dp) + 1 ;
        // delete
        int delete = recurs(word1 , word2 , i-1 , j , dp) + 1 ;
        // replace
        int replace = recurs(word1 , word2 , i-1 , j-1 , dp) + 1 ;
        
        int ans =  Math.min(insert , Math.min(delete , replace));
        dp[i][j] = ans ;
        return ans ;
    }
}