//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<String> set = new HashSet<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i =0 ; i < grid.length ; i++){
            for(int j =0 ; j < grid[0].length ; j++){
                this.sb = new StringBuilder();
                if(visited[i][j] == false && grid[i][j] == 1){
                    dfs(grid , i , j , visited);
                    set.add(sb.toString());
                }
            }
        }
        // System.out.println(set);
        return set.size();
    }
    StringBuilder sb ;
    void dfs(int grid[][] , int i , int j , boolean[][] visited){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || visited[i][j] || grid[i][j] == 0)return ;
        visited[i][j] = true ;
        sb.append('d') ;
        dfs(grid , i+1 , j , visited);
        sb.append('u') ;
        dfs(grid , i-1 , j , visited);
        sb.append('r');
        dfs(grid , i , j+1 , visited);
        sb.append('l');
        dfs(grid , i , j-1 , visited);
        sb.append('z');
    }
}
