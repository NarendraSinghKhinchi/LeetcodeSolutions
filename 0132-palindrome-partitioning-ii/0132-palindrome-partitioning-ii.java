class Solution {
    public int minCut(String s) {
        int dp[]= new int[s.length()];
        Arrays.fill(dp , -1);
        int ans = recur(0 , s , dp);
        
        return ans-1 ;
    }
    public int recur(int idx , String s , int dp[]){
        if(idx == s.length())return 0 ;
        if(dp[idx] != -1)return dp[idx];
        int min = Integer.MAX_VALUE ;
        
        for(int j = idx ; j < s.length() ; j++){
            if(palin(idx , j , s)){
                int curr = 1 + recur(j+1 , s , dp);
                min = Math.min(curr , min);
            }
        }
        dp[idx] = min ;
       
        return min ;
    }
    public boolean palin(int i , int j , String s){
        
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--))return false ;
        }
        return true ;
    }
}