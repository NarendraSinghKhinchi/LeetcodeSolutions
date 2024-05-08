class RandomizedSet {
    
    HashMap<Integer,Integer> hm ;
    ArrayList<Integer> list ;
    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>() ;
    }
    
    public boolean insert(int val) {
        
        if(hm.containsKey(val)){
            return false ;
        }
        hm.put(val, list.size()) ;
        list.add(val) ;
        return true ;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val))return false ;
        
        int idx = hm.get(val);
        hm.remove(val) ;
        int last = list.get(list.size()-1);
        list.set(idx, last);
        if(val != last){
            hm.put(last,idx);
        }
        list.remove(list.size()-1);
        return true ;
    }
    
    public int getRandom() {
        int size = list.size() ;
        int rand = (int) (Math.random()*size);
        
        return list.get(rand) ;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */