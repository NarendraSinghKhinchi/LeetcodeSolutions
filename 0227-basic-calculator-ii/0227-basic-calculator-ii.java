class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char sign = '+' ;
        int len = s.length();
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
                    st.push(val);
                }else if(sign == '-'){
                    st.push(-val);
                }else if(sign == '*'){
                    int a= st.pop();
                    st.push(a*val);
                }else if(sign == '/'){
                    int a= st.pop();
                    st.push(a/val);
                }
            }else if(ch != ' '){
                sign = ch ;
            }
        }
        int ans = 0 ;
        while(st.size() > 0) ans += st.pop();
        return ans ;
    }
}