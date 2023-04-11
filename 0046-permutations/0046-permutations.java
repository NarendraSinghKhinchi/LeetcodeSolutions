class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean selected[] = new boolean[nums.length];
        dfs(list , curr , nums , 0 , selected);
        return list ;
    }
    public void dfs(List<List<Integer>> list ,List<Integer> curr , int[]nums , int idx , boolean selected[]){
        if(idx == nums.length){
            list.add(new ArrayList<>(curr));
            return ;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(selected[i] == false){
                curr.add(nums[i]);
                selected[i] = true ;
                dfs(list , curr , nums , idx+1 , selected);
                selected[i] = false ;
                curr.remove(curr.size()-1);
            }
        }
    }
}