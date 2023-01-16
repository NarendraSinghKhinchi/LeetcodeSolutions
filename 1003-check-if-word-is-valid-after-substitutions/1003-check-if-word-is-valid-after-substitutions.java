class Solution {
    public boolean isValid(String s) {
       Deque<Character> st = new ArrayDeque<>();
        for(int i =0  ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                st.push(ch);
            }else if(ch == 'b'){
                if(st.size() > 0 && st.peek() == 'a')st.pop();
                else return false ;
                st.push(ch);
            }else{
                if(st.size() > 0 && st.peek() == 'b')st.pop();
                else st.push(ch);
            }
        }
        if(st.size() != 0)return false ;
        
        return true ;
    }
}