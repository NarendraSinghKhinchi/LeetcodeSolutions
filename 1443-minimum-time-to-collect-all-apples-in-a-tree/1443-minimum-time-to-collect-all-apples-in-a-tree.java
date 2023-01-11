class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer,ArrayList<Integer>> tree = new HashMap<>();
        for(int i = 0 ; i < n ; i++)tree.put(i , new ArrayList<>());
        for(int ed[] : edges){
            tree.get(ed[0]).add(ed[1]) ;
            tree.get(ed[1]).add(ed[0]);
        }
        boolean visited[] = new boolean[n];
        int time = dfs(tree , 0 , hasApple , visited);
        if(time == -1)return 0 ;
        return time ;
    }
    public int dfs(HashMap<Integer,ArrayList<Integer>> tree , int node , List<Boolean> hasApple , boolean visited[]){
        if(node > hasApple.size())return -1 ;

        visited[node] = true ;
        int curr = 0 ;
        for(int x : tree.get(node)){
            if(visited[x] == false){
                int c = dfs(tree , x , hasApple , visited);
                if(c != -1)curr += c + 2 ;
            }
        }
        
        if(hasApple.get(node)){
            return curr ;
        }
        if(curr == 0)curr = -1 ;
        return curr ;
    }
    
}