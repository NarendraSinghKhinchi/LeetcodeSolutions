class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();
        for(int i = 0 ; i < logs.length ; i++){
            if(logs[i].equals("./"))continue ;
            if(logs[i].equals("../")){
                if(st.size() > 0)st.pop();
                continue ;
            }
            st.push(logs[i]) ;
        }
        return st.size();
    }
}