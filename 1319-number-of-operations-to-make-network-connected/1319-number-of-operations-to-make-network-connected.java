class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)return -1 ;
        int dis[] = new int[n];
        int rank[] = new int[n];
        for(int i = 0 ; i < n ; i++)dis[i] = i ;
        int count = 0 ;
        for(int con[] : connections){
            int p = find(dis , con[0]);
            int q = find(dis , con[1]) ;
            if(p != q){
                union(dis , rank , con[0] , con[1]) ;
                count += 1 ;
            }   
        }
        return (n-count)-1 ;
    }
    public int find(int dis[] , int no){
        if(dis[no]  == no)return no ;
        return dis[no] = find(dis , dis[no]);
    }
    public void union(int dis[] ,int rank[] , int x , int y){
        int p = find(dis , x);
        int q = find(dis , y);
        // if(rank[p] < rank[q]){
            dis[p] = q ;
            rank[q]++ ;
        // }else{
        //     dis[q] = p ;
        //     rank[p]++ ;
        // }
        
        
    }
}