class Solution {
    public int minimumLength(String s) {
        int i = 0 ;
        int j = s.length()-1 ;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                int k = i ;
                while(s.charAt(k) == s.charAt(i) && k < j)k++ ;
                i = k ;
                k = j ;
                while(s.charAt(k) == s.charAt(j) && i <= k)k-- ;
                j = k ;
            }else break ;
        }
        return j-i+1 ;
    }
}