class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : stones)pq.add(x);
        
        while(pq.size() >= 2){
            int f = pq.remove();
            int s = pq.remove();
            if(f == s)continue ;
            pq.add(Math.abs(f-s));
        }
        if(pq.isEmpty())return 0 ;
        return pq.peek();
    }
}