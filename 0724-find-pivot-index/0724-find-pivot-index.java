class Solution {
    public int pivotIndex(int[] nums) {
        int pre[] = new int[nums.length];
        int post[] = new int[nums.length];
        
        for(int i = 0 ; i < nums.length; i ++){
            int j = nums.length-i-1 ;
            if(i == 0){
                pre[i] = nums[i] ;
                post[j] = nums[j] ;
            }else{
                pre[i] = nums[i]+pre[i-1];
                post[j] = nums[j]+post[j+1] ;
            }
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            int left = i > 0 ? pre[i-1] : 0 ;
            int right = i < nums.length-1 ? post[i+1] : 0 ;
            if(left == right)return i ;
        }
        
        return -1 ;
    }
}