class Solution {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        int n = bombs.length ;
        for(int i = 0 ; i < n ; i++)graph.put(i , new ArrayList<>());
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j)continue ;
                int xi = bombs[i][0] ;
                int yi = bombs[i][1] ;
                int ri = bombs[i][2] ;
                int xj = bombs[j][0] ;
                int yj = bombs[j][1] ;
                // distance square
                long dis = (long)(xi-xj)* (long)(xi-xj) + (long)(yi-yj)*(long)(yi-yj) ;
                if((long)ri*ri >= dis ){
                    graph.get(i).add(j);
                }
            }
        }
        int ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            int curr = dfs(graph , i , new HashSet<>() );
            ans = Math.max(curr , ans);
        }
        return ans ;
    }
    public int dfs(HashMap<Integer,ArrayList<Integer>> graph , int i , HashSet<Integer> set){
        int count = 1 ;
        set.add(i);
        for(int nbr : graph.get(i)){
            if(!set.contains(nbr)){
                count += dfs(graph , nbr , set);
            }
        }
        return count ;
    }
}