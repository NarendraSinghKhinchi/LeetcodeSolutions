class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < operations.length ; i++){
            String ch = operations[i];
            if(ch.equals("C")){
                st.pop();
            }else if(ch.equals("D")){
                st.push(st.peek() * 2);
            }else if(ch.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(b);
                st.push(a);
                st.push(a+b);
            }else{
                st.push(Integer.parseInt(ch));
            }
        }
        int sum = 0 ; 
        for(int x : st)sum += x ;
        return sum ;
    }
}