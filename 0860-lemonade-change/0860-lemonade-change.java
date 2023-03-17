class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Arrays.sort(bills) ;
        int five = 0 ;
        int ten = 0 ;
       
        for(int bill : bills){
            if(bill == 5)five += 1 ;
            if(bill == 10 ){
                five -= 1 ;
                ten += 1 ;
            }
            if(bill == 20 ){
               bill = 15 ;
               while(ten > 0 && bill > 5){
                   ten -= 1 ;
                   bill -= 10 ;
               }
               while(bill > 0){
                   bill -= 5 ;
                   five -= 1 ;
               }
               
            }
            if(five < 0 ) return false ;
        }
        return true ;
    }
}