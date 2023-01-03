class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0 ;
        for(int col = 0 ; col < strs[0].length() ; col++){
            for(int row = 1 ; row < strs.length ; row++){
                char ch1 = strs[row].charAt(col) ;
                
                char ch2 = strs[row-1].charAt(col) ;
                if(ch1 < ch2){
                    count++ ;
                    break ;
                }
            }
        }
        return count ;
    }
}