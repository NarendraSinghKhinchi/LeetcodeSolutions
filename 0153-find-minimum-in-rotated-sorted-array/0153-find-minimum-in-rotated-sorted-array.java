class Solution {
    public int findMin(int[] nums) {
        int low = 0 ;
        int high = nums.length-1 ;
        int midVal = Integer.MAX_VALUE ;
        
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if(nums[low] <= nums[mid]){
                // left is sorted
                midVal = Math.min(nums[low] , midVal);
                low = mid+1 ;
            }else{
                // right is sorted
                midVal = Math.min(nums[high] , midVal);
                high = mid ;
            }
            // System.out.println(midVal);
        }
        return midVal ;
    }
    
}