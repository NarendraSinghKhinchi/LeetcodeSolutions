class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)list.add(new ArrayList<>());
        
        for(int flight[] : flights){
            list.get(flight[0]).add(new int[]{flight[1] , flight[2]});
        }
        int visited[] = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1] , b[1]));
        // nextnode , cost , stops/k
        pq.add(new int[]{src , 0 , 0});
        visited[src] = 0 ;
        while(pq.isEmpty() == false){
            int rem[] = pq.remove();
            if(rem[0] == dst && rem[2]-1 <= k)return rem[1];
            visited[rem[0]] = rem[2] ;
            if(rem[2]-1 > k) continue ;
            
            for(int[] nbrs : list.get(rem[0])){
                if(rem[2]+1 < visited[nbrs[0]]){
                    pq.add(new int[]{nbrs[0] , rem[1]+nbrs[1] , rem[2]+1});
                }
            }
            
        }
        return -1 ;
    }
}