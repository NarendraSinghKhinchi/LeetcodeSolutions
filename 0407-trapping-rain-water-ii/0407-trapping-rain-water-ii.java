class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length ;
        int n = heightMap[0].length ;
        boolean visited[][] = new boolean[m][n] ;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0 ; i < m ; i++){
            for(int j =0 ; j < n ; j++){
                if(i == 0 || j== 0 || i == m-1 || j == n-1){
                    visited[i][j] = true ;
                    pq.add(new Pair(i , j , heightMap[i][j]));
                }
            }
        }
        int dirs[][] = {{1,0} , {-1,0} , {0,-1} , {0,1}} ;
        int water = 0 ;
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            for(int dir[] : dirs){
                int x = rem.row + dir[0];
                int y = rem.col + dir[1];
                if(x < 0 || y < 0 || x == m || y == n || visited[x][y])continue ;
                
                water += Math.max(0 , rem.height - heightMap[x][y]) ;
                visited[x][y] = true ;
                int delegate = heightMap[x][y] ;
                if(rem.height > delegate){
                    delegate = rem.height ;
                }
                pq.add(new Pair(x , y , delegate));
                
            }
        }
        return water ;
    }
    class Pair implements Comparable<Pair>{
        int row ;
        int col ;
        int height ;
        public Pair(int row , int col , int height){
            this.row = row ;
            this.col  = col ;
            this.height = height ;
        }
        @Override
        public int compareTo(Pair o){
            return this.height - o.height ;
        }
    }
}