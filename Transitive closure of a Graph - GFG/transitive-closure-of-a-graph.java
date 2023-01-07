//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
        ArrayList<ArrayList<Integer>> clo = new ArrayList<>();
        for(int i = 0 ; i < N ; i++)clo.add(new ArrayList<>());
        for(int i = 0 ; i < N ; i++){
            for(int j =0 ; j < N ; j++){
                boolean visited[] = new boolean[N] ;
                boolean reach = isReach(N , graph , i , j ,visited );
                int bool = reach ? 1 : 0 ;
                if(i==j)bool = 1 ;
                clo.get(i).add(bool);
            }
        }
        return clo ;
    }
    static boolean isReach(int N , int graph[][] , int src , int dest , boolean visited[]){
        if(graph[src][dest]==1)return true;
        visited[src]=true;
        for(int i = 0 ; i < graph[0].length ; i++){
            if(graph[src][i] == 1 && !visited[i]){
                boolean bool = isReach(N ,graph,i, dest , visited);
                if(bool)return true;
            }
        }
        return false;
    }
}