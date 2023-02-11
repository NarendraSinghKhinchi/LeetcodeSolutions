class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0 ; i+needle.length() <= haystack.length() ; i++){
            char ch = haystack.charAt(i);
            if(ch == needle.charAt(0)){
                if(haystack.substring(i , i+needle.length()).equals(needle))return i ;
            }
        }
        return -1 ;
    }
}