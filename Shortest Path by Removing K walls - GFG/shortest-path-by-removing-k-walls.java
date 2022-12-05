//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);
            
            int[][] mat = new int[n][m];
            
            for(int i=0; i<n; i++)
            {
                String S[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat,n,m,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static class Node{
        int i , j , k , dis ;
        Node (int i , int j , int k , int dis){
            this.i = i;
            this.j = j ;
            this.k = k ;
            this.dis = dis ;
        }
    }
    static int shotestPath(int[][] mat, int n, int m, int K) {
        // code here
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0 , 0 , 0 , 0));
        int [][] vis = new int[n][m];
        for(int[] i : vis)Arrays.fill(i , Integer.MAX_VALUE);
        int [][]moves = {{0,-1},{0,1},{1,0},{-1,0}} ;
        
        while(queue.size() > 0){
            
            Node rem = queue.remove() ;
            int i = rem.i ;
            int j = rem.j ;
            int k = rem.k ;
            int dis = rem.dis ;
            
            if(i == n-1 && j == m-1)return dis ;
            if(k >= vis[i][j])continue ;
            vis[i][j] = k ;
            if(mat[i][j] == 1)k++ ;
            if(k > K)continue ;
            // System.out.println(i + " " + j );
            for(int ptr = 0 ; ptr < moves.length ; ptr++){
                int ni = moves[ptr][0] + i ;
                int nj = moves[ptr][1] + j ;
                if(ni >= 0 && nj >= 0 && ni < n && nj < m ){
                    queue.offer(new Node (ni , nj , k , dis+1)) ;
                } 
            }
        }
        return -1 ;
    }
}



























