class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> list = new ArrayList<>();
        boolean visited[] = new boolean[n];
        // ArrayList<Integer> graph[] = new ArrayList[n];
        // for(int i = 0 ; i < graph.length ; i++)graph[i] = new ArrayList<>();
        
        for(List<Integer> edge : edges){
            visited[edge.get(1)] = true ;
        }
        for(int i = 0 ; i < n ;i++){
            if(!visited[i])list.add(i);
        }
        // Queue<Integer> q = new ArrayDeque<>();
//         for(int i = 0 ; i < n ; i++){
//             if(visited[i])continue ;
//             list.add(i);
//             q.add(i);
//             while(q.isEmpty() == false){
//                 int rem = q.remove();
//                 visited[rem] = true ;
//                 for(int nbr : graph[rem]){
//                     if(!visited[nbr]){
//                         q.add(nbr);
//                     }
//                 }
//             }
            
//         }
        return list ;
    }
}