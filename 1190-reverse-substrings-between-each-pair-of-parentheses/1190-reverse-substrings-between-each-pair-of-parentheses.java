class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int pairs[] = new int[n];
        Stack<Integer> st = new Stack<>() ;
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i) ;
            if(c == '(')st.push(i) ;
            if(c == ')'){
                pairs[i] = st.peek() ;
                pairs[st.pop()] = i ;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 , d = 1 ; i < n ; i+= d){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = pairs[i] ;
                d = -d ;
            }else{
                sb.append(s.charAt(i));;
            }
        }
        return sb.toString();
    }
}
 