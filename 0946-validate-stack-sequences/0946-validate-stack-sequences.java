class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0 ;
        for(int i = 0 ; i < pushed.length && j < popped.length ; i++){
            int k = i ;
            while(j < popped.length && i >= 0){
                if(pushed[i] == popped[j] ){
                    pushed[i] = -1 ;
                    j++ ;
                    i-- ;
                }else if(pushed[i] == -1)i-- ;
                else break ;
            }
            i = k ;
            
        }
        int i = pushed.length-1 ;
        while(i >= 0 && pushed[i] == -1)i-- ;
        System.out.println(i + " " + j);

        while(j < popped.length && i >= 0){
            if(popped[j] != pushed[i])return false ;
            j++ ;
            i-- ;
            while(i >= 0 && pushed[i] == -1)i-- ;
            // System.out.println(i + " " + j);
        }
        if(i < 0 && j >= popped.length)return true ;
        return false ;
    }
}