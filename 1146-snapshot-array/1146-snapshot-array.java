class SnapshotArray {

    List<HashMap<Integer,Integer>> list ;
    int snapId ;
    public SnapshotArray(int length) {
        this.list = new ArrayList<>();
        for(int i = 0 ; i < length ;i++){
            list.add(new HashMap<>());
        }
        this.snapId = 0 ;
    }
    
    public void set(int index, int val) {
        HashMap<Integer,Integer> hm = list.get(index);
        hm.put(snapId , val);
    }
    
    public int snap() {
        return snapId++ ;
    }
    
    public int get(int index, int snap_id) {
        HashMap<Integer,Integer> hm = list.get(index);
        if(hm.containsKey(snap_id)){
            return hm.get(snap_id);
        }
        
        // int lo = 0 ;
        // int hi = snap_id ;
        int idx = 0 ;
        // while(lo <= hi){
        //     int mid = (lo+hi)/2 ;
        //     if(hm.containsKey(mid)){
        //         idx = mid ;
        //         lo = mid+1 ;
        //     }else 
        //         hi = mid-1 ;
        // }
        while(snap_id-- >= 0){
            if(hm.containsKey(snap_id))return hm.get(snap_id);
            
        }
        
        return hm.getOrDefault(idx,0) ;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */