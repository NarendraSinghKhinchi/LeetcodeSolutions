class RandomizedSet {
    
    HashSet<Integer> store ;
    public RandomizedSet() {
        this.store = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(store.contains(val))return false;
        store.add(val);
        return true ;
    }
    
    public boolean remove(int val) {
        if(!store.contains(val))return false ;
        store.remove(val);
        return true ;
    }
    
    public int getRandom() {
        ArrayList<Integer> list = new ArrayList<>(store);
        int idx = (int) (Math.random()*list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */