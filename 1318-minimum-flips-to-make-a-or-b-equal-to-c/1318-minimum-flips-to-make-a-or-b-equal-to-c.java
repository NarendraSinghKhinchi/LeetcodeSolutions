class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0 ;
//         0|0 = 0 
//         1|0 = 1 
//         1|1 = 1
//         0|1 = 1 
        for(int i = 0 ; i < 32 ; i++){
            int cbit = ((1 << i) & c) > 0 ? 1 : 0 ;
            int abit = ((1 << i) & a) > 0 ? 1 : 0 ;
            int bbit = ((1 << i) & b) > 0 ? 1 : 0 ;
            
            if(cbit == 0){
                count += abit ;
                count += bbit ;
            }else if(abit == 0 && bbit == 0){
                count += 1 ;
            }
        }
        return count ;
    }
}