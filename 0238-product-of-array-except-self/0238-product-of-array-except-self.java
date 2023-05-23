class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre[] = new int[nums.length];
        int pos[] = new int[nums.length];
        pre[0] = nums[0] ;
        for(int i = 1 ;i < nums.length ; i++){
            pre[i] = pre[i-1]*nums[i] ;
        }
        
        pos[nums.length-1] = nums[nums.length-1] ;
        for(int i = nums.length-2 ; i >= 0 ; i--){
            pos[i] = pos[i+1]*nums[i] ;
        }
        
        int arr[] = new int[nums.length];
        arr[0] = pos[1];
        arr[nums.length-1] = pre[nums.length-2];
        
        for(int i = 1 ;i < nums.length-1 ; i++){
            arr[i] = pre[i-1]*pos[i+1];
        }
        
        return arr ;
    }
}