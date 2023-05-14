class Solution {
    int nums[] ;
    
    public Solution(int[] nums) {
        this.nums = nums ;
        
    }
    
    public int[] reset() {
        return nums ;
    }
    
    public int[] shuffle() {
        int i = 0 ;
        int arr[] = new int[nums.length];
        HashSet<Integer> set = new HashSet<>();
        while(i < nums.length){
            int idx = (int)(Math.random()*(nums.length));
            if(!set.contains(idx)){
                arr[i++] = nums[idx];
                set.add(idx);
            }
        }
        return arr ;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */