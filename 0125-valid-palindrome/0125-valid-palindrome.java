class Solution {
    public boolean isPalindrome(String s) {
        
        int i = 0 ;
        int j = s.length() - 1 ;
        while(i < j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(!isAlpha(ch1))i++ ;
            else if(!isAlpha(ch2)) j-- ;
            else if(small(ch1) != small(ch2))return false ;
            else {
                i++ ;
                j-- ;
            }
        }
        return true ;
    }
    public boolean isAlpha(char c){
        if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z' || ( c >= '0' && c <= '9'))) {
          return true ;
        }
        return false ;
    }
    public char small(char ch){
        if(ch >= 'a' && ch <= 'z')return ch ;
        return (char)(ch+32) ;
    }
}