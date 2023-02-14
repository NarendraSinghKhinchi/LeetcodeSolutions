class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 1 ; i <= nums.length ; i++){
            int idx = search(nums , i) ;
            
            if(nums.length - idx == i)return i ;
        }
        return -1 ;
    }
    public int search(int nums [] , int target){
        int low = 0 ;
        int high = nums.length ;
        while(low < high){
            int mid = (low+high)/2 ;
            if(nums[mid] >= target){
                high = mid ;
            }else low = mid+1 ;
        }
        return high ;
    }
}