class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        Interval in = new Interval(newInterval[0] , newInterval[1]);
        Stack<Interval> st = new Stack<>();
        for(int inter[] : intervals){
            Interval curr = new Interval(inter[0],inter[1]);
            if(in != null && curr.start > in.start){
                st.push(in) ;
                in = null ;
            }
            while(st.size() > 1){
                Interval first = st.pop() ;
                Interval second = st.pop();
                if(first.start <= second.end){
                    first.start = Math.min(first.start , second.start);
                    first.end = Math.max(first.end , second.end);
                    st.push(first);
                }else{
                    st.push(second);
                    st.push(first);
                    break;
                }
            }
            st.push(curr);
        }
        if(in != null)st.push(in);
         while(st.size() > 1){
                Interval first = st.pop() ;
                Interval second = st.pop();
                if(first.start <= second.end){
                    first.start = Math.min(first.start , second.start);
                    first.end = Math.max(first.end , second.end);
                    st.push(first);
                }else{
                    st.push(second);
                    st.push(first);
                    break;
                }
            }
        int ans[][] = new int[st.size()][2];
        for(int i = ans.length - 1 ; i >= 0 ; i--){
            Interval pop = st.pop();
            ans[i][0] = pop.start ;
            ans[i][1] = pop.end ;
        }
        return ans ;
    }
    class Interval{
        int start , end ;
        Interval(int s , int e){
            this.start = s ;
            this.end = e ;
        }
    }
}