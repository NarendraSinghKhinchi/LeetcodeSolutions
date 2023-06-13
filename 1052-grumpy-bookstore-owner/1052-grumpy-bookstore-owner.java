class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int cus = 0 ;
        for(int i= 0 ;i  < customers.length ; i++){
            if(grumpy[i] == 0){
                cus += customers[i] ;
            }
        }
        int i = 0;
        int j = 0 ;
        while(j < customers.length && j < minutes){
            if(grumpy[j] == 1)cus += customers[j] ;
            j++ ;
        }
        int max = cus ;
        while(j < customers.length){
            if(grumpy[i] == 1)cus -= customers[i] ;
            if(grumpy[j] == 1)cus += customers[j] ;
            max = Math.max(cus , max);
            j++ ;
            i++ ;
        }
        return max ;
    }
}