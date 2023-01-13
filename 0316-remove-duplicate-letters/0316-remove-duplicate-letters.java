class Solution {
    public String removeDuplicateLetters(String s) {
        
        int count[] = new int[26];
        boolean used[] = new boolean[26];
        for(int i = 0 ; i < s.length() ; i++){
            int idx = (int)(s.charAt(i) - 'a') ;
            count[idx]++ ;
            used[idx] = false ;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            int idx = (int)(ch - 'a') ;
            count[idx]-- ;
            if(used[idx] == true)continue ;
            while(st.size() != 0 && st.peek() > ch ){
                int id = (int)(st.peek() - 'a') ;
                if(count[id] != 0){
                    st.pop();
                    used[id] = false ;
                }else break ;
            }
            
            st.push(ch);
            used[idx] = true ;
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}