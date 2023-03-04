class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> p = new ArrayDeque<>();
        Queue<int[]> a = new ArrayDeque<>();
        int n = heights.length ;
        int m = heights[0].length ;
        boolean pacific[][] = new boolean[n][m] ;
        boolean atlantic[][] = new boolean[n][m] ;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 || j == 0){
                    pacific[i][j] = true ;
                    p.add(new int[]{i , j});
                }
                if(i == n-1 || j == m-1){
                    atlantic[i][j] = true;
                    a.add(new int[]{i, j});
                }
            }
        }
        
        
        bfs(p , pacific , heights);
        bfs(a , atlantic , heights);
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                
                if(pacific[i][j] && atlantic[i][j] ){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    list.add(curr);
                }
            }
            
        }
        return list ;
    }
    // public void bfs(Queue<int[]> queue, boolean[][]visited , int[][]matrix){
    //     int n = matrix.length, m = matrix[0].length;
    //     int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    //     while(!queue.isEmpty()){
    //         int[] cur = queue.poll();
    //         for(int[] d:dir){
    //             int x = cur[0]+d[0];
    //             int y = cur[1]+d[1];
    //             if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
    //                 continue;
    //             }
    //             visited[x][y] = true;
    //             queue.offer(new int[]{x, y});
    //         } 
    //     }
    // }
    public void bfs(Queue<int[]> q , boolean visited[][] , int heights[][]){
        int[][]dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int n = heights.length ;
        int m = heights[0].length ;
        while(q.isEmpty() == false){
            int cur[] = q.remove();
            
            for(int dir[] : dirs){
                int x = cur[0] + dir[0] ;
                int y = cur[1] + dir[1] ;
                if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y])continue ;
                if(heights[x][y] >= heights[cur[0]][cur[1]] ){
                    visited[x][y] = true ;
                    q.add(new int[]{x , y});
                }
            }
        }
    }
}
// public class Solution {
//     int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
//     public List<int[]> pacificAtlantic(int[][] matrix) {
//         List<int[]> res = new LinkedList<>();
//         if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
//             return res;
//         }
//         int n = matrix.length, m = matrix[0].length;
//         //One visited map for each ocean
//         boolean[][] pacific = new boolean[n][m];
//         boolean[][] atlantic = new boolean[n][m];
//         Queue<int[]> pQueue = new LinkedList<>();
//         Queue<int[]> aQueue = new LinkedList<>();
//         for(int i=0; i<n; i++){ //Vertical border
//             pQueue.offer(new int[]{i, 0});
//             aQueue.offer(new int[]{i, m-1});
//             pacific[i][0] = true;
//             atlantic[i][m-1] = true;
//         }
//         for(int i=0; i<m; i++){ //Horizontal border
//             pQueue.offer(new int[]{0, i});
//             aQueue.offer(new int[]{n-1, i});
//             pacific[0][i] = true;
//             atlantic[n-1][i] = true;
//         }
//         bfs(matrix, pQueue, pacific);
//         bfs(matrix, aQueue, atlantic);
//         for(int i=0; i<n; i++){
//             for(int j=0; j<m; j++){
//                 if(pacific[i][j] && atlantic[i][j])
//                     res.add(new int[]{i,j});
//             }
//         }
//         return res;
//     }
    
// }