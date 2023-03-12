class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<int []>> list = new ArrayList<>();
        for(int i =0 ; i < n ; i++)list.add(new ArrayList<>());
        for(int time[] : times){
            list.get(time[0]-1).add(new int[]{time[1]-1 , time[2]});
        }
        int dis[] = new int[n];
        boolean selected[] = new boolean[n];
        Arrays.fill(dis , Integer.MAX_VALUE);
        dis[k-1] = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            int u = selectmin(dis , selected);
            
            selected[u] = true ;
            
            for(int[] next : list.get(u)){
                int v = next[0];
                int cost = next[1];
                if(selected[v] == false && dis[u] != Integer.MAX_VALUE ){
                    if( dis[u] + cost < dis[v])dis[v] = dis[u] + cost ;
                }
            }
        }
        
        int min = Integer.MIN_VALUE ;
        for(int x : dis){
            if(x == Integer.MAX_VALUE)return -1;
            min = Math.max(min , x);
        }
        return min; 
    }
    
    public int selectmin(int dis[] , boolean selected[]){
        int min = -1 ;
        for(int i = 0 ; i < dis.length ; i++){
            if(selected[i] == false && (min == -1 || dis[i] < dis[min] )){
                min = i ;
            }
        }
        return min ;
    }
}