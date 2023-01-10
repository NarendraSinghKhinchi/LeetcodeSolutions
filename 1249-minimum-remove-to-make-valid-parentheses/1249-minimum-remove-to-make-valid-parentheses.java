class Solution {
    public String minRemoveToMakeValid(String s) {
        char arr[] = s.toCharArray();
        int open = 0 ;
        int close = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(arr[i] == '(')open++ ;
            else if(arr[i] == ')'){
                if(open > 0){
                    open-- ;
                }else arr[i] = 'A' ;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = arr.length - 1 ; j >= 0 ; j--){
            char ch = arr[j] ;
            if(ch == 'A')continue ;
            if(ch == ')'){
                close++ ;
                sb.append(ch) ;
            }else if(ch == '('){
                if(close > 0){
                    close-- ;
                    sb.append(ch) ;
                }
            }else {
                sb.append(ch) ;
            }
        }
        return sb.reverse().toString();
    }
}