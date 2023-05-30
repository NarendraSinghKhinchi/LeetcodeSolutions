class RandomizedCollection {

    ArrayList<Integer> list ;
    HashMap<Integer,HashSet<Integer>> hm ;
    public RandomizedCollection() {
        this.list = new ArrayList<>();
        this.hm = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val) == true){
            HashSet<Integer> indexes = hm.get(val);
            indexes.add(list.size());
            list.add(val);
            return false ;
        }
        HashSet<Integer> set = new HashSet<>();
        hm.put(val , set);
        set.add(list.size());
        list.add(val);
        return true ;
    }
    
    public boolean remove(int val) {
        if(hm.containsKey(val) == false)return false ;
        
        HashSet<Integer> indexset = hm.get(val);
        HashSet<Integer> lastidxset = hm.get(list.get(list.size()-1));
        
        
        int curridx = -1 ;
        for(int idx : indexset){
            curridx = Math.max(idx , curridx) ;
            
        }
        
        list.set(curridx , list.get(list.size()-1));
        lastidxset.remove(list.size()-1);
        list.remove(list.size()-1);
        lastidxset.add(curridx);
        
        indexset.remove(curridx);
        
        if(indexset.size() == 0)hm.remove(val);
        
        return true ;
    }
    
    public int getRandom() {
        int idx = (int)(Math.random()*list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */