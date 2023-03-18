class Solution {
    public int numberOfSubstrings(String s) {
        
        int count[] = new int[3];
        
        int res = 0 ;
        int i = 0 ;
        for(int j = 0 ; j < s.length() ; j++){
            char ch = s.charAt(j);
            count[ch-'a']++ ;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                res += s.length() - j  ;
                char ch2 = s.charAt(i++) ;
                count[ch2-'a']-- ;
            }
            
        }
        return res ;
    }
}