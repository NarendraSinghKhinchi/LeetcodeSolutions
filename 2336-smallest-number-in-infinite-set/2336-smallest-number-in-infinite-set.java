class SmallestInfiniteSet {
    HashSet<Integer> set ;
    public SmallestInfiniteSet() {
        this.set = new HashSet<>();
        for(int i = 1 ; i <= 1000 ; i++){
            set.add(i);
        }
    }
    
    public int popSmallest() {
        int l = 1 ;
        int h = 1000 ;
        int ans = 1 ;
        for(int i = 1 ; i <= h ; i++){
            if(set.contains(i)){
                ans = i ;
                break ;
            }
        }
        set.remove(ans);
        return ans ;
    }
    
    public void addBack(int num) {
        set.add(num);
    }
    
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */