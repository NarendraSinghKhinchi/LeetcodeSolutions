class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int lon =0 ;
        for(int x : nums)set.add(x);
        
        for(int i = 0 ; i < nums.length ; i++){
            if(!set.contains(nums[i] - 1)){
                int streak = 1 ;
                int nu = nums[i] ;
                while(set.contains(nu+1)){
                    nu += 1 ;
                    streak += 1 ;
                }
                lon = Math.max(streak , lon);
            }
        }
        return lon ;
    }
}