class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int dp[][][] = new int[m+1][n+1][strs.length] ;
        for(int ds[][] : dp){
            for(int d[] : ds){
                Arrays.fill(d , -1) ; 
            }
        }
        int ans = findMax(strs , m , n , strs.length-1 , dp) ;
        
        return ans ;
    }
    public int findMax(String []strs , int m , int n , int idx ,int dp[][][]){
        
        // if(m == 0 && n == 0)return 1 ;
        if(idx == -1 || m < 0 || n < 0)return 0 ;
        if(dp[m][n][idx] != -1)return dp[m][n][idx] ;
        
        String str = strs[idx] ;
        int one = 0 ;
        int zero = 0 ;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == '0')zero++ ;
            else one++ ;
        }
        int inc = 0;
        if(m >= zero && n >= one)
             inc = findMax(strs , m-zero , n-one , idx-1 , dp) + 1;
        int exc = findMax(strs , m , n , idx-1 , dp) ;
        
        dp[m][n][idx] =  Math.max(inc , exc);
        return dp[m][n][idx] ;
    }
}