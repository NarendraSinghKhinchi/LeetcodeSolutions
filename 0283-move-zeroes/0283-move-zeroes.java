class Solution {
    public void moveZeroes(int[] nums) {
        int nz = 0 ;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] != 0){
                nums[nz++] = nums[i];
            }
        }
        while(nz < nums.length){
            nums[nz++] = 0 ;
        }
    }
}