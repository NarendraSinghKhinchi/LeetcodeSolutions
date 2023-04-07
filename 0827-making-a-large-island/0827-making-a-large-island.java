class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length ;
        int dis[] = new int[n*n];
        int size[] = new int[n*n];
        for(int i = 0 ; i < n*n ; i++){
            dis[i] = i ;
            size[i] = 1 ;
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0)continue ;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                for(int ind = 0 ; ind < 4 ; ind++){
                    int newr = i+dr[ind];
                    int newc = j+dc[ind];
                    if(isValid(newr , newc , n) && grid[newr][newc] == 1){
                        int node = i*n + j ;
                        int adnode = newr*n + newc ;
                        union(dis , size , node , adnode);
                    }
                }
            }
        }
        int max = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1)continue ;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> set = new HashSet<>();
                for(int ind = 0 ; ind < 4 ; ind++){
                    int newr = i+dr[ind];
                    int newc = j+dc[ind];
                    if(isValid(newr , newc , n) && grid[newr][newc] == 1){
                        int node = newr*n + newc ;
                        int par = find(dis , node);
                        set.add(par);
                    }
                }
                int tsize = 0 ;
                for(int par : set){
                    tsize += size[par];
                }
                max = Math.max(max , tsize+1);
            }
        }
        
        for(int x : size){
            max = Math.max(x , max);
        }
        return max ;
    }
    public int find(int dis[] , int n){
        if(dis[n] == n)return n ;
        return dis[n] = find(dis , dis[n]);
    }
    public void union(int dis[] , int size[] , int x , int y){
        int p = find(dis , x);
        int q = find(dis , y);
        if(p == q)return ;
        if(size[p] < size[q]){
            dis[p] = q ;
            size[q] += size[p];
        }else{
            dis[q] = p ;
            size[p] += size[q];
        }  
    }
    private boolean isValid(int newr ,int newc ,int n ){
        return newr >= 0 && newr < n && newc >= 0 && newc < n ;
    }
}