class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        int yes[] = new int[nums.length+1] ;
        int no[] = new int[nums.length+1] ;
        yes[1] = nums[0] ;
        no[1]  = 0 ;
        for(int i = 2 ; i <= nums.length ; i++){
            int curr = nums[i-1] ;
            no[i] = Math.max(no[i-1] , no[i-2]+curr) ;
            yes[i] = Math.max(yes[i-1] , yes[i-2]+curr) ;
        }
        return Math.max(no[nums.length] , yes[nums.length-1]) ;
    }
}