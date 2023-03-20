class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length-3 ; i++){
            for(int j = i + 1 ; j < nums.length - 2 ; j++){
                int l = j+1 ;
                int h = nums.length-1 ;
                while(l < h){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[l] + (long)nums[h] ;
                    if(sum == target){
                        List<Integer> lis = new ArrayList<>();
                        lis.add(nums[i]);
                        lis.add(nums[j]);
                        lis.add(nums[l]);
                        lis.add(nums[h]) ;
                        list.add(lis);
                        while(i < nums.length - 4 && nums[i] == nums[i+1])i++ ;
                        while(l < h && nums[l] == nums[l+1])l++ ;
                        while(h > l && nums[h] == nums[h-1])h-- ;
                        while(j < nums.length - 3 && nums[j] == nums[j+1])j++ ;
                    }
                    if(sum < target)l++ ;
                    else h-- ;
                }
            }
        }
        
        return list ;
    }
}