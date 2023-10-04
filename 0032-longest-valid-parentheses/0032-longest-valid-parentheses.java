class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int lon = 0 ;
        st.push(-1);
        for(int i = 0; i < s.length() ;i++){
            char ch = s.charAt(i);
            if(ch == '(' || st.peek() == -1 || s.charAt(st.peek()) != '('){
                st.push(i);
            }else {
                st.pop();
            }
        }
        st.push(s.length());
        while(st.size() > 1){
            int curr = st.pop()-st.peek()-1 ;
            lon = Math.max(curr,lon);
        }
        return lon ;
    }
}