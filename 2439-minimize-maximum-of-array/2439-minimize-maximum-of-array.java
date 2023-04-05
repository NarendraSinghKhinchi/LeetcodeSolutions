class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int l = 0 ;
        int max = 0 ;
        for(int x : nums)
            max = Math.max(x , max);
        int ans = max ;
        while(l <= max){
            int mid = (l+max)/2 ;
            boolean bool = search(nums , mid);
            if(bool){
                ans = mid ;
                max = mid-1 ;
            }else
                l = mid+1 ;
        }
        return ans ;
    }
    public boolean search(int nums[] , int limit){
        long ex = 0 ;
        for(int x : nums){
            if(x > limit){
                long c = (x-limit);
                if(ex < c)return false ;
                ex -= c ;
            }else{
                ex += (limit - x) ;
            }
        }
        return true ;
    }
}