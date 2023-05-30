class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1 ;
        for(int i = nums.length-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                idx = i ;
                break ;
            }
        }
        if(idx != -1){
            for(int i = nums.length-1 ; i > idx ; i--){
                if(nums[i] > nums[idx]){
                    int t = nums[i] ;
                    nums[i] = nums[idx] ;
                    nums[idx] = t ;
                    break ;
                }
            }
        }
        reverse(nums ,idx+1);
    }
    public void reverse(int[]nums , int start){
        
        int end = nums.length -  1;
        while(start < end){
            int t = nums[start];
            nums[start] = nums[end] ;
            nums[end] = t ;
            start++ ;
            end-- ;
        }
    }
}