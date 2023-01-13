class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();

        int prMin[] = new int[nums.length];
        prMin[0] = nums[0] ;
        for(int i = 1 ; i < nums.length ; i++){
            prMin[i] = Math.min(nums[i] ,prMin[i-1] );
        }
        st.clear();
        for(int j = nums.length-1 ; j>= 0 ; j--){
            while(!st.isEmpty() && st.peek() <= prMin[j])st.pop();
            
            if(!st.isEmpty() &&  st.peek() < nums[j] ){
                return true ;
            }
            
            st.push(nums[j]);
        }
        
        return false;
    }
}









