class Solution {
    public int compress(char[] chars) {
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0 ;
        while( i < chars.length ){
            char ch = chars[i];
            int count = 0 ;
            int j = i ;
            while(j < chars.length && chars[j] == ch){
                j++ ;
                count++ ;
                i++ ;
            }
            sb.append(ch );
            
            if(count > 1 ){
                sb.append(count );
            }
        }
        // System.out.println(sb);
        for( i = 0 ; i < sb.length() ; i++){
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}