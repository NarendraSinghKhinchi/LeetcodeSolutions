class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        int par[] = new int[n];
        Arrays.fill(par , -1);
        
        for(List<Integer> edge : edges){
            par[edge.get(1)] = edge.get(0);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(par[i] == -1)list.add(i);
        }
        return list ;
    }
}