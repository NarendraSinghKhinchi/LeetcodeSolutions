class Solution {
    public void sortColors(int[] nums) {
        
        int z = 0 ;
        int o = 0;
        int t = nums.length-1 ;
        while(o <= t){
            if(nums[o] == 0){
                nums[o] = nums[z];
                nums[z] = 0 ;
                o++ ;
                z++ ;
            }else if(nums[o] == 2){
                nums[o] = nums[t];
                nums[t] = 2 ;
                t-- ;
            }else o++ ;
        }
    }
}