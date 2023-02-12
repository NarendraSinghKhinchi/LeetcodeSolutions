class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low = 0 ;
        int high = nums.length - 1 ; 
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] == target){
                low = mid ;
                high =  mid ;
                break ;
            }
        
            if(nums[mid] < target)low = mid+1 ;
            else high = mid - 1 ;
        }
        if(low > high)return new int[]{-1 , -1} ;
        
        while(low >= 1){
            // System.out.println(low);
            if(nums[low-1] == target)low-- ;
            else break ;
        }
        while(high < nums.length-1){
            if(nums[high+1] == target)high++ ;
            else break ;
        }
        return new int[]{low , high};
    }
}