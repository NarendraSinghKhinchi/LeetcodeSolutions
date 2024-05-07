class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre[] = new int[nums.length] ;
        int post[] = new int[nums.length] ;
        
        pre[0] = nums[0] ;
        post[nums.length-1] = nums[nums.length-1] ;
        for(int i = 0 ; i < nums.length; i++){
            if(i > 0) pre[i] = nums[i]*pre[i-1] ;
            if(i < nums.length-1){
                int j = nums.length-i-2 ;
                post[j] = post[j+1]*nums[j] ;
            }
        }
        int ans[] = new int[nums.length] ;
        
        for(int i = 0 ; i < nums.length ; i++){
            if(i == 0)ans[i] = post[i+1] ;
            else if (i == nums.length-1) ans[i] = pre[i-1] ;
            else ans[i] = pre[i-1]*post[i+1] ;
        }
      return ans ;
    }
}