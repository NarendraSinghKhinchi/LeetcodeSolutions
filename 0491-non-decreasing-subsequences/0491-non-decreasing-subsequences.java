class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        HashSet<List<Integer>> set = new HashSet<>() ;
        
        sub(new ArrayList<>() , set , 0 , nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> list : set){
            ans.add(list);
        }
        return ans ;
    }
    public void sub(List<Integer> list , HashSet<List<Integer>> set , int idx , int nums[]){
        if(idx >= nums.length){
            if(list.size() >= 2){
                set.add(new ArrayList<>(list));
            }
            return ;
        }
        sub(list , set , idx+1 , nums);
        int player = nums[idx];
        if(list.size() == 0 || list.get(list.size() - 1) <= player){
            list.add(player);
            sub(list , set , idx+1 , nums);
            list.remove(list.size()-1);
        }
    }
}