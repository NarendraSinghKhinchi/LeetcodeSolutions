class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length ;
        int m = heights[0].length ;
        
        // greedy is not going to work here so can't use dijkstra with priorityQueue directly 
        int dirs[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        
        int dis[][] = new int[n][m];
        for(int d[] : dis)Arrays.fill(d , Integer.MAX_VALUE);
        pq.add(new int[]{0 , 0 , 0}); // rw , col , distance
        dis[0][0] = 0 ;
        
        while(pq.isEmpty() == false){
            int []rem = pq.remove();
            
            for(int dir[] : dirs){
                int nr = rem[0] + dir[0];
                int nc = rem[1] + dir[1];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    int cost = Math.abs(heights[nr][nc] - heights[rem[0]][rem[1]]);
                    int currcost = Math.max(cost , rem[2]);
                    if(currcost < dis[nr][nc]){
                        pq.add(new int[]{nr , nc , currcost});
                        dis[nr][nc] = currcost ;
                    }
                }
            }
        }
        
        return dis[n-1][m-1];
    }
}