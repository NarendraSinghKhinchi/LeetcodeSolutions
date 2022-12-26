class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0 ;
        int range = Integer.MAX_VALUE ;
        int sum = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i] ;
            while(sum >= target){
                range = Math.min(range , i-left+1) ;
                sum -= nums[left] ;
                left++ ;
            } 
        }
        return range == Integer.MAX_VALUE ? 0 : range ;
    }
}