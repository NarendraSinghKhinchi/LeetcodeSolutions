class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        
        for(int i = 0; i < groupSizes.length; i++){
            int group = groupSizes[i];
            if(hm.containsKey(group)){
                List<Integer> list = hm.get(group);
                if(list.size() == group){
                    ans.add(list);
                    list = new ArrayList<>();
                    list.add(i);
                    hm.put(group,list);
                }else{
                    list.add(i);
                }
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(group,list);
            }
        }
        for(int x : hm.keySet()){
            ans.add(hm.get(x));
        }
        return ans ;
    }
}