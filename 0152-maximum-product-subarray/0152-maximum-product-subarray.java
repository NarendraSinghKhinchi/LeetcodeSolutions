class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];
        
        for(int i =1 ; i < nums.length ;i++){
            int x = nums[i] ;
            int temp = max ;
            
            max = Math.max(Math.max(max*x,min*x) , x);
            min = Math.min(Math.min(temp*x,min*x), x);
            
            ans = Math.max(max , ans);
            
        }
        return ans ;
    }
}