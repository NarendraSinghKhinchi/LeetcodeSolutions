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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int dis[] = new int[n] ;
        Arrays.fill(dis ,Integer.MAX_VALUE);
        dis[0] = 0 ;
        for(int relax = 0 ; relax < n ; relax++){
            for(int edge[] : edges){
                int u = dis[edge[0]] ;
                int cost = edge[2] ;
                int v = dis[edge[1]] ;
                if(u != Integer.MAX_VALUE && u+cost < v){
                    dis[edge[1]] = u + cost ;
                }
            }
        }
        int newdis[] = new int[n] ;
        for(int i = 0 ; i < n ;i++)newdis[i]=dis[i] ;
        for(int edge[] : edges){
            int u = newdis[edge[0]] ;
            int cost = edge[2] ;
            int v = newdis[edge[1]] ;
            if(u != Integer.MAX_VALUE && u+cost < v){
                newdis[edge[1]] = u + cost ;
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(newdis[i] != dis[i])return 1; 
        }
        return 0 ;
    }
}




















