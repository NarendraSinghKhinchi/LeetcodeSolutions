class ParkingSystem {

    public ParkingSystem(int big, int medium, int small) {
        this.big = big ;
        this.medium = medium ;
        this.small = small ;
    }
    int big,medium,small ;
    public boolean addCar(int carType) {
        
        switch(carType){
            case 1 :
                if(big >= 1){
                    big -= 1; 
                    return true ;
                }
                break ;
            case 2 :
                if(medium >= 1){
                    medium -= 1; 
                    return true ;
                }
                break ;
            case 3 :
                if(small >= 1){
                    small -= 1; 
                    return true ;
                }
                break ;
        }
        return false ;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */