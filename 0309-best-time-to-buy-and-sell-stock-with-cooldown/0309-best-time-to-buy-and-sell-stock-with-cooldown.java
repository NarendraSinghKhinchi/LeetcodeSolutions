class Solution {
    public int maxProfit(int[] prices) {
        
        int buyingstate = -(prices[0]) ;
        int sellingstate = 0 ;
        int previousselling = 0 ;
        for(int i = 1 ; i < prices.length ; i++){
            
            int buytoday = previousselling - prices[i] ;
            int selltoday = prices[i] + buyingstate ;
            
            previousselling = sellingstate ;
            buyingstate = Math.max(buyingstate , buytoday);
            sellingstate = Math.max(sellingstate , selltoday) ;
        }
        return sellingstate ;
    }
}
