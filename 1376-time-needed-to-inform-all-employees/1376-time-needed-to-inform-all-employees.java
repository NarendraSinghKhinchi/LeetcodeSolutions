class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer> []graph = new ArrayList[n];
        for(int i= 0 ;i < n ; i++)graph[i] = new ArrayList<>();
        
        for(int i = 0 ; i < manager.length ; i++){
            int man = manager[i] ;
            if(man != -1)
                graph[man].add(i);
        }
        int time = dfs(graph , informTime , headID);
        return time ;
    }
    public int dfs(ArrayList<Integer> []graph , int[]informTime , int emId){
        
        int time = 0 ;
        ArrayList<Integer> sub = graph[emId];
        if(sub.size() > 0){
            time = informTime[emId] ;
        }
        int max = 0 ;
        for(int subordi : sub){
            int t = dfs(graph , informTime , subordi);
            max = Math.max(max , t);
        }
        time += max ;
        return time ;
    }
}