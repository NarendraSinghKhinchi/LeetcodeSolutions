class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0 ;
        for(int i = 0 ; i < gas.length ; i++){
            if(gas[i] > cost[i]){
                start = i ;
                break ;
            }
        }
        int currgas = 0 ;
        int i ;
        for(i = start ; i < gas.length ;){
            currgas += gas[i]-cost[i] ;
            if(currgas < 0){
                i++ ;
                while(i < gas.length){
                    if(gas[i] > cost[i]){
                        start = i ;
                        currgas = 0 ;
                        break ;
                    }
                    i++ ;
                }
            }else{
                i++ ;
            }
        }
        if(currgas < 0)return -1 ;
        for(int j = 0 ; j < start ; j++){
            currgas += gas[j]-cost[j];
            if(currgas < 0)return -1 ;
        }
        return start ;
    }
}