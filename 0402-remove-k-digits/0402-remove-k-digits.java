class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0 ; i < num.length() ; i++){
            int curr = num.charAt(i) - '0' ;
            while(st.size() > 0 && k > 0 && st.peek() > curr){
                st.pop();
                k-- ;
            }
            st.push(curr);
        }
        while(k-- > 0 && st.size() > 0)st.pop();
        StringBuilder sb = new StringBuilder();
        while(st.isEmpty() == false){
            sb.append(st.pop()) ;
        }
        String ans = sb.reverse().toString();
        int i = 0 ;
        while(i < ans.length() ){
            if(ans.charAt(i) != '0')break ;
            i++ ;
        }
        ans = ans.substring(i) ;
        if(ans.length() == 0)return "0" ;
        return ans  ;
    }
}















