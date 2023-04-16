class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int dp[][] = new int[n+1][k+1] ;
        
        for(int d[] : dp)Arrays.fill(d , -1);
        
        return recurs(piles , n , k , dp);
    }
    public int recurs(List<List<Integer>> piles , int i , int k , int dp[][]){
        if(i == 0)return 0 ;
        if(dp[i][k] != -1)return dp[i][k]; 
        
        int currentSum = 0 ;
        for (int currentCoins = 0; currentCoins <= Math.min(piles.get(i - 1).size(), k); currentCoins++) {
            if (currentCoins > 0) {
                currentSum += piles.get(i - 1).get(currentCoins - 1);
            }
            dp[i][k] = Math.max(dp[i][k], recurs(piles, i - 1, k - currentCoins , dp) + currentSum);
        }
        return dp[i][k];
    }
}