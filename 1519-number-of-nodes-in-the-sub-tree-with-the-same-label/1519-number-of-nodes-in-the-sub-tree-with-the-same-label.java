class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer> tree[] = new ArrayList [n];
        for(int i = 0 ; i < tree.length ; i++){
            tree[i] = new ArrayList<>();
        }
        for(int edge[] : edges){
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        int ans[] = new int[n];
        dfs(tree , 0 , labels , ans , -1);
        
        return ans ;
    }
    public HashMap<Character,Integer> dfs(ArrayList<Integer> tree[] , int v ,String labels , int ans[] , int parent){
        // if(v >= labels.length())return new HashMap<>();
        // we don't need above statement because you are using loop for call selfbounded
        
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put(labels.charAt(v) , 1);
        
        for(int nbr : tree[v]){
            if(nbr != parent){
                HashMap<Character,Integer> child = dfs(tree , nbr , labels, ans , v);
                for(char ch : child.keySet()){
                    hm.put(ch , hm.getOrDefault(ch , 0) + child.get(ch));
                }
            }
        }
        ans[v] = hm.get(labels.charAt(v));
            
        return hm ;
    }
}