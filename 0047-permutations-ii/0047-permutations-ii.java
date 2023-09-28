class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        
        pemu(nums, 0, list, new ArrayList<>(), new boolean[nums.length]);
        return list ;
    }
    public void pemu(int []nums, int i, List<List<Integer>> list , List<Integer> ans, boolean bool[] ){
        if(ans.size() == nums.length){
            if(!list.contains(ans))list.add(new ArrayList<>(ans));
            return ;
        }
        for(int j = 0; j < nums.length ; j++)
        if(!bool[j]){
            bool[j] = true ;
            ans.add(nums[j]);
            pemu(nums, j+1, list , ans , bool);
            ans.remove(ans.size()-1);
            bool[j] = false ;
        }
    }
}