class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0 ;
        int cost = prices[0];
        int sell = prices[0] ;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < sell){
                maxprofit += sell-cost ;
                cost = prices[i] ;
                sell = prices[i] ;
            }else{
                sell = Math.max(sell, prices[i]);
            }
        }
        maxprofit += sell-cost ;
        return maxprofit ;
    }
}