class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        
        
        for(int i = 0 ; i < numRows ; i++){
            List<Integer> curr = new ArrayList<>();
            
            for(int j = 0 ; j <= i ; j++){
                if(j == 0)curr.add(1);
                else if(j == i)curr.add(1);
                else{
                    List<Integer> prev = list.get(i-1);
                    curr.add(prev.get(j) + prev.get(j-1));
                }
            }
            
            list.add(curr);
        }
        return list ;
    }
}