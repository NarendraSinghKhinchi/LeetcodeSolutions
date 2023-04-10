class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        combine(candidates , target , 0 , list , ans , 0);
        
        return list ;
    }
    public void combine(int []candidate , int target , int idx ,List<List<Integer>> list ,List<Integer> ans , int curr){
        if(idx >= candidate.length)return ;
        if(curr > target){
            return ;
        }
        if(curr == target){
            List<Integer> listu = new ArrayList<>();
            for(int x : ans )listu.add(x);
            list.add(listu);
            return ;
        }
        
        combine(candidate , target , idx+1 , list , ans , curr);
        ans.add(candidate[idx]);
        combine(candidate , target , idx , list , ans , curr+candidate[idx]);
        ans.remove(ans.size()-1);
        // combine(candidate , target , idx+ , list , ans , curr);
    }
}