class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length ;
        int left[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(st.size() > 0 && heights[st.peek()] >= heights[i])st.pop() ;
            if(st.size() == 0)left[i] = 0 ;
            else left[i] = st.peek()+1 ;
            st.push(i) ;
            
           // System.out.println(left[i]);
        }
        st.clear();
        int right[] = new int[n];
        for(int i = n - 1 ; i >=0 ; i--){
            while(st.size()>0 && heights[st.peek()] >= heights[i])st.pop();
            if(st.size() == 0)right[i] = n-1 ;
            else right[i] = st.peek()-1 ;
            st.push(i);
            // System.out.println(right[i]);
        }
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < n ; i++){
            int curr = (right[i] - left[i] + 1)*heights[i] ;
            max = Math.max(max , curr);
        }
        return max ;
    }
}