class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char sign = '+' ;
        int len = s.length();
        int lastnum = 0 , result = 0 ;
        for(int i = 0 ; i < len ; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int val = 0 ;
                while(i < len && Character.isDigit(s.charAt(i))){
                    val = val*10 + (s.charAt(i) - '0') ;
                    i++ ;
                }
                i-- ;
                if(sign == '+'){
                    result += lastnum ;
                    lastnum = val ;
                }else if(sign == '-'){
                    result += lastnum ;
                    lastnum = -val ;
                }else if(sign == '*'){
                    lastnum = lastnum * val ;
                }else if(sign == '/'){
                    lastnum = lastnum / val ;
                }
            }else if(ch != ' '){
                sign = ch ;
            }
        }
        return lastnum + result ;
    }
}
