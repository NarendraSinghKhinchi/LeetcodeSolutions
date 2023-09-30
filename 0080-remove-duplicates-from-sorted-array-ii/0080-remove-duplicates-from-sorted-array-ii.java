class Solution {
    public int removeDuplicates(int[] nums) {
        int head = 2 ;
        int tail = 1 ;
        while(head < nums.length){
            int candi = nums[head++];
            
            if(nums[tail] == candi && nums[tail-1] != candi){
                nums[++tail] = candi ;
            }else if(nums[tail] != candi){
                nums[++tail] = candi ;
            }
            
        }
        return tail + 1 ;
    }
}