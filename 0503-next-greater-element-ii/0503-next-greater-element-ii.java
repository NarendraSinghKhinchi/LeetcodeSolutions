class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>() ;
        int res[] = new int[nums.length] ;
        for(int i = nums.length*2 ; i >= 0 ; i-- ){
            int j = i % nums.length ;
            while(st.size() > 0 && st.peek() <= nums[j] )st.pop() ;
            
            if(st.size() == 0){
                res[j] = -1 ;
            }else{
                res[j] = st.peek() ;
            }
            st.push(nums[j]) ;
        }
        return res ;
    }
}