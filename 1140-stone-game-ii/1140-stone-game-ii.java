class Solution {
    public int stoneGameII(int[] piles) {
        this.dp = new int[piles.length+1][piles.length+1][2];
        for(int d[][] : dp){
            for(int t[] : d)Arrays.fill(t , -1);
        }
        int ans = simulate(piles, 0 , 1, 0);
        return ans;
    }
    int dp[][][] ;
    public int simulate(int[]piles , int idx, int m, int alice){
        if(idx >= piles.length)return 0 ;
        if(dp[idx][m][alice] != -1)return dp[idx][m][alice] ;
        int k = 1 ;
        int i = idx ;
        int score = 0 ;
        int currscore = 0 ;
        if(alice == 0)
            while(k <= 2*m && i < piles.length){
                currscore += piles[i] ;
                score = Math.max(score , currscore+simulate(piles, i+1, Math.max(k,m), 1));
                i++ ;
                k++ ;
            }
        else{
            score = Integer.MAX_VALUE ;
            while(k <= 2*m && i < piles.length){
                score = Math.min(score , simulate(piles, i+1, Math.max(k,m), 0));
                i++ ;
                k++ ;
            }}
        
        dp[idx][m][alice] = score ;
        return score ;
    }
    
    
    
}