class Solution {
    public int pivotIndex(int[] nums) {
        int right[] = new int[nums.length];
        right[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            right[i] = nums[i]+right[i+1];
        }
        int left = 0 ;
        for(int i = 0 ; i < nums.length-1 ; i++){
            if(left == right[i+1])return i ;
            left += nums[i] ;
        }
        if(left == 0)return nums.length-1 ;
        return -1 ;
    }
}