class UndergroundSystem {

    HashMap<Integer,Pair> checkIn ;
    HashMap<String,int[]> timeKeeper ;
    // at 0 will store the total sum of time and at 1 will store the total traveller's count
    public UndergroundSystem() {
        this.checkIn = new HashMap<>();
        this.timeKeeper = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Pair p = new Pair(t , stationName);
        checkIn.put(id,p);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p = checkIn.get(id);
        String code = encode(p.station , stationName);
        checkIn.remove(id);
        if(!timeKeeper.containsKey(code)){
            int arr[] = new int[2];
            arr[1] = 1 ;
            arr[0] = (t-p.time);
            timeKeeper.put(code , arr);
        }else{
            int arr[] = timeKeeper.get(code);
            arr[0] += (t-p.time);
            arr[1] += 1 ;
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int arr[] = timeKeeper.get(encode(startStation , endStation));
        
        double time = arr[0] ;
        double count = arr[1] ;
        
        return time/count ;
    }
    class Pair{
        String station ;
        int time ;
        Pair(int t , String str){
            this.station = str ;
            this.time = t ;
        }
    }
    public String encode(String str1 , String str2){
        return str1 + "%%%" + str2 ;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */