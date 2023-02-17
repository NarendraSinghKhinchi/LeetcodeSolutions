class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder() ;
        StringBuilder tb = new StringBuilder() ;
        int i = 0 , j = 0 ;
        while(i < s.length() || j < t.length()){
            if(i < s.length()){
                char ch1 = s.charAt(i) ;
                if(ch1 == '#' && sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }else if(ch1 != '#') sb.append(ch1) ;
                i++ ;
            }
            if(j < t.length()){
                char ch2 = t.charAt(j) ;
                if(ch2 == '#' && tb.length() > 0){
                    tb.deleteCharAt(tb.length() - 1);
                }else if(ch2 != '#') tb.append(ch2) ;
                j++ ;
            }
        }
        String s1 = sb.toString();
        String s2 = tb.toString() ;
        
        return s1.equals(s2);
    }
}