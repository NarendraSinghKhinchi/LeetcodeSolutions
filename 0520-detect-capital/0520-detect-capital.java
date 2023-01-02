class Solution {
    public boolean detectCapitalUse(String word) {
        char frst = word.charAt(0) ;
        boolean cap = false ;
        boolean small = false ;
        if(frst <= 'z' && frst >= 'a'){
            small = true ;
        }
        for(int i = 1 ; i < word.length() ; i++){
            char ch = word.charAt(i) ;
            if(ch >= 'A' && ch <= 'Z'){
                if(small)return false ;
                cap = true ;
            }else{
                if(cap)return false ;
                small = true ;
            }
        }
        return true ;
    }
}