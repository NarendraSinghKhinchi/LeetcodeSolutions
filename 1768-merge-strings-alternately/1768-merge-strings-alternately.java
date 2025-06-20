class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0 ; 
        int j = 0 ;
        boolean bool = true ;
        while(i < word1.length() && j < word2.length()){
            if(bool){
                sb.append(word1.charAt(i++));
            }else{
                sb.append(word2.charAt(j++));
            }
            bool = !bool ;
        }
        if(i < word1.length()){
            sb.append(word1.substring(i));
        }
        if(j < word2.length()){
            sb.append(word2.substring(j));
        }
        return sb.toString();
    }
}