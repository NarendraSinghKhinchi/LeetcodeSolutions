class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> list =  new ArrayList<>();
        list.add(1);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(list);
        for(int i = 1 ; i < numRows ; i++){
            List<Integer> curr = ans.get(i-1);
            List<Integer> n = new ArrayList<>();
            for(int j = 0 ; j <= i ; j++){
                if(j == 0 || j == i){
                    n.add(1);
                }else{
                    n.add(curr.get(j-1)+curr.get(j));
                }
            }
            ans.add(n);
        }
        
        return ans ;
    }
}