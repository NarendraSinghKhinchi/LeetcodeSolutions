class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0l ;
        int i = 0 ; 
        int j = 0 ;
        while(j < nums.length){
            if(nums[j] == 0){
                ans += (j-i+1);
                j++ ;
            }else{
                j++ ;
                i = j ;
            }
        }
        return ans ;
    }
}