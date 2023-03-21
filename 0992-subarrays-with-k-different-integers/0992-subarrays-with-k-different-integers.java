class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return sub(nums , k ) - sub(nums , k-1) ;
    }
    public int sub(int nums[] ,int k){
        int count = 0 ;
        int i = 0 ; 
        int j = 0 ;
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        while(j < nums.length){
            hm.put(nums[j] , hm.getOrDefault(nums[j] , 0) + 1) ;
            
            while(hm.size() > k){
                hm.put(nums[i], hm.get(nums[i]) - 1);
                if(hm.get(nums[i]) == 0)hm.remove(nums[i]) ;
                i++ ;
            }
            
            count += j-i+1 ;
            
            j++ ;
        }
        return count ;
    }
}