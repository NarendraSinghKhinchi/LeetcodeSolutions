class KthLargest {

    int k ;
    PriorityQueue<Integer> pq ;
    public KthLargest(int k, int[] nums) {
        this.k = k ;
        this.pq = new PriorityQueue<>();
        for(int x : nums){
            add(x);
        }
        
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k)pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */