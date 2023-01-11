class RecentCounter {

    public RecentCounter() {
        this.deque = new LinkedList<>();
    }
    Deque<Integer> deque ;
    public int ping(int t) {
        int lo = t - 3000 ;
        while(deque.size() > 0){
            if(deque.getFirst() < lo){
                deque.removeFirst();
            }else break ;
        }
        deque.addLast(t);
        return deque.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */