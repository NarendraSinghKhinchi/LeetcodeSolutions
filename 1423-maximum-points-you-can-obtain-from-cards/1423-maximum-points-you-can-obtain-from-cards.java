class Solution {
    public int maxScore(int[] cardPoints, int k) {
        k = cardPoints.length - k ;
        int total = 0 ;
        for(int x : cardPoints)total += x ;
        int j = 0 ;
        int window = 0 ;
        while(k-- > 0){
            window += cardPoints[j++];
        }
        int i = 0 ;
        int max = total - window ;
        while(j < cardPoints.length){
            window -= cardPoints[i++];
            window += cardPoints[j++];
            max = Math.max(max , total-window);
        }
        return max ;
    }
}