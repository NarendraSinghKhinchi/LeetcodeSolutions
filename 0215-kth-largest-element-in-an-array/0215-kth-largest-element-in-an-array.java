class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        k = nums.length - k ;
        for(int x : nums){
            pq.add(x);
        }
        while(k-- > 0)pq.remove();
        return pq.remove();
    }
}