class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '*' || ch == '(')st.push(ch) ;
            if(ch == ')'){
                int star = 0 ;
                while(st.size() > 0 && st.peek() != '('){
                    if(st.peek() == '*')star += 1 ;
                    st.pop();
                }
                if(st.size() == 0 && star == 0)return false ;
                if(st.size() > 0 && st.peek() == '(')st.pop();
                else star -= 1 ;
                while(star-- > 0){
                    st.push('*') ;
                }
            }
        }
        int star = 0 ;
        int open = 0 ;
        while(st.size() > 0){
            if(st.peek() == '*')star += 1 ;
            else open += 1 ;
            
            if(open > star)return false ;
            st.pop();
        }
        
        return true ;
    }
}