class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums) ;
        List<List<Integer>> list = new ArrayList<>() ;
        for(int i = 0 ; i < nums.length - 2 ; i++){
            if(i > 0 && nums[i] == nums[i-1])continue ;
            int l = i + 1 ;
            int h = nums.length - 1 ;
            while(l < h){
                int sum = nums[i] + nums[l] + nums[h] ;
                if(sum == 0){
                    ArrayList<Integer> li = new ArrayList<>();
                    li.add(nums[i]); li.add(nums[l]); li.add(nums[h]) ;
                    list.add(li);
                       l++ ; h-- ;
                    while((l < h) && (nums[l] == nums[l-1]))l++;// avoid duplicates
                    while((l < h) && (nums[h] == nums[h+1]))h--;// avoid duplicates
                }else if(sum < 0){
                    l += 1 ;
                }else{
                    h -= 1; ;
                }
            }
            
        }
        return list ;
    
    }
}