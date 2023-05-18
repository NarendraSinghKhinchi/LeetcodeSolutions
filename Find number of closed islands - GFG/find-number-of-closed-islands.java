//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        int count = 0 ;
        boolean visited[][] = new boolean[N][M] ;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(matrix[i][j] == 1 && visited[i][j] == false && dfs(matrix , i , j , visited)){
                    count++ ;
                }
            }
        }
        return count ;
    }
    public boolean dfs(int [][]mat , int i , int j , boolean [][] visited){
        if(visited[i][j] == true)return true ;
        if(i == 0 || j == 0 || i == mat.length-1 || j == mat[0].length - 1){
            return mat[i][j] == 0 ;
        }
        if(mat[i][j] == 0)return true ;
        visited[i][j] = true ;
        
        boolean left = dfs(mat , i , j-1 , visited);
        boolean right = dfs(mat , i , j+1 , visited);
        boolean up = dfs(mat , i-1 , j , visited);
        boolean down = dfs(mat , i+1 , j , visited);
     
        return left&&right&&down&&up ;   
    }
}