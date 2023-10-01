class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        sub(nums, 0, new ArrayList<>(), ans);
        return ans ;
    }
    public void sub(int[]nums, int i , List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        
        for(; i < nums.length; i++){
            list.add(nums[i]);
            sub(nums,i+1, list, ans);
            list.remove(list.size()-1);
            while(i+1 < nums.length && nums[i] == nums[i+1])i++ ;
        }
        
    }
}