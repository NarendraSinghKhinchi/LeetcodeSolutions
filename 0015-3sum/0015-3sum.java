class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        HashSet<List<Integer>> hs = new HashSet<>();
        
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length ;i++){
            int j = i+1 ; 
            int k = nums.length-1 ; 
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k] ;
                
                if(sum == 0 ){
                    hs.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                }else if(sum < 0)j++ ;
                else k-- ;
            }
        }
        return new ArrayList<>(hs);
    }
}