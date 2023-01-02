class Solution {
    public boolean detectCapitalUse(String word) {
        boolean small = false ;
        boolean cap = false ;
        if(word.charAt(0) <= 'z' && word.charAt(0) >= 'a'){
            small = true ;
        }
        for(int i = 1 ; i < word.length() ; i++){
            char ch = word.charAt(i) ;
            if(ch <= 'z' && ch >= 'a'){
                if(cap)return false ;
                small = true ;
            }else{
                if(small)return false ;
                cap = true ;
            }
            
        }
        return true ;
    }
}