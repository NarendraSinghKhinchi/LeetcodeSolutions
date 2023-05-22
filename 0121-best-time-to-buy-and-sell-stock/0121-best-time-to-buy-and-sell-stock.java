class Solution {
    public int maxProfit(int[] prices) {
        int min[] = new int[prices.length];
        min[0] = prices[0] ;
        for(int i = 1 ;  i < min.length ; i++){
            
            min[i] = Math.min(prices[i] , min[i-1]);
        }
        int max = 0 ;
        for(int i = 0 ; i < prices.length ; i++){
            max = Math.max(max , prices[i]-min[i]);
        }
        return max ;
    }
}