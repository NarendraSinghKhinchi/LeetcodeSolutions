class Solution {
    public int search(int[] nums, int target) {
        return rot(nums , target , 0 , nums.length-1);
    }
    public int rot(int nums[] , int target , int low , int high ){
        if(high < low)return -1 ;
        int mid = low + (high-low)/2 ;
        
        if(nums[mid] >= nums[low]){
            // left part is sorted
            int bin = binary(nums , low , mid , target ) ;
            if(bin != -1)return bin ;
            return rot(nums , target , mid+1 , high);
        }else if(nums[mid] < nums[high] ){
            // right part is sorted
            int bin = binary(nums , mid , high , target ) ;
            if(bin != -1)return bin ;
            return rot(nums , target , low , mid-1 );
        }
        return -1 ;
    }
    public int binary(int nums[] , int low , int high , int target){
        
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] == target)return mid ;
            if(nums[mid] < target)low = mid+1 ;
            else high = mid-1 ;
        }
        return -1 ;
    }
}