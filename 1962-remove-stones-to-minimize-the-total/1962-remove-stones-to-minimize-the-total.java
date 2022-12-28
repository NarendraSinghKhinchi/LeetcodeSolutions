class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a) ;
        for(int i = 0 ; i < piles.length ; i++){
            pq.add(piles[i]) ;
        }
        while(k > 0){
            k-- ;
            int pile = pq.remove() ;
            int rem = pile/2 ;
            pq.add(pile - rem);
        }
        int ans = 0 ;
        for(int x : pq){
            ans += x ;
        }
        return ans ;
    }
}