class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        swapRange(sb , 0 , sb.length()-1);
        
        int i = 0 ;
        while(i < sb.length()){
            char ch = sb.charAt(i);
            if(ch != ' ')break ;
            sb.deleteCharAt(i--);
            i++ ;
        }
        while(i < sb.length()){
            int j = i ;
            while(j < sb.length()){
                char ch = sb.charAt(j);
                if(ch == ' ')break ;
                j++ ;
            }
            swapRange(sb , i , j-1);
            j++ ;
            i = j ;
            while(i < sb.length()){
                char ch = sb.charAt(i);
                if(ch != ' ')break ;
                sb.deleteCharAt(i--);
                i++ ;
            } 
        }
        int j = sb.length()-1 ;
        while(j >= 0 ){
            char ch = sb.charAt(j);
            if(ch != ' ')break ;
            sb.deleteCharAt(j);
            j-- ;
        } 
        return sb.toString() ;
    }
    public void swapRange(StringBuilder sb, int i , int j){
        while(i < j){
            char ch = sb.charAt(i);
            char ch2 = sb.charAt(j);
            sb.setCharAt(i , ch2);
            sb.setCharAt(j , ch);
            i++ ;
            j-- ;
        }
    }
}