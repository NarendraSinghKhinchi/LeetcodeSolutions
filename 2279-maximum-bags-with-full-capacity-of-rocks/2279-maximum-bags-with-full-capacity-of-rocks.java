class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
       PriorityQueue<Integer> pq = new PriorityQueue<>() ;
       
       for(int i = 0 ; i < rocks.length ; i++){
           pq.add(capacity[i]-rocks[i]) ;
       }
       int max = 0 ;
        while(pq.size() > 0 && additionalRocks > 0){
            int rem = pq.remove() ;
            if(rem == 0) max+= 1 ;
            else{
                if(rem <= additionalRocks){
                    additionalRocks -= rem ;
                    max+= 1 ;
                }
            }
        }
        return max ;
    }
}