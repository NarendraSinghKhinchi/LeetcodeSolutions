//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int count = 0 ;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++ ;
                    dfs(visited , grid , i , j);
                }
            }
        }
        return count ;
    }
    public void dfs(boolean visited[][] , char grid[][] , int i  , int j){
        if(i < 0 || j < 0 || i >= visited.length || j >= grid[0].length || visited[i][j] || grid[i][j] != '1')return ;
        visited[i][j] = true ;
        dfs(visited , grid , i-1 , j);
        dfs(visited , grid , i-1 , j+1);
        dfs(visited , grid , i , j+1);
        dfs(visited , grid , i+1 , j+1);
        dfs(visited , grid , i+1 , j);
        dfs(visited , grid , i+1 , j-1);
        dfs(visited , grid , i , j-1);
        dfs(visited , grid , i-1 , j-1);
        
    }
    public int find(int dis[] , int no){
        if(dis[no] == no)return no ;
        return dis[no] = find(dis , dis[no]);
    }
    public void union(int dis[] , int x , int y){
        int p = find(dis , x );
        int q = find(dis , y) ;
        dis[p] = q ;
    }
}