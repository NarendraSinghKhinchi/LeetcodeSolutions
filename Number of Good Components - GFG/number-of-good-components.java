//{ Driver Code Starts
// Initial Template for Java

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
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // System.out.println(V);
        int good = 0 ;
        boolean visited[] = new boolean[V+1] ;
        for(int i = 1 ; i < adj.size() ; i++){
            if(visited[i] == false){
                int req = dfs(i , adj , visited);
                boolean vis[] = new boolean[V+1];
                if(isGood(i , req-1 , adj , vis))good += 1 ;
            }
        }
        return good ;
    }
    public int dfs(int V , ArrayList<ArrayList<Integer>> adj , boolean visited[]){
        
        visited[V] = true ;
        int count = 1 ;
        for(int x : adj.get(V)){
            if(visited[x] == false){
                count += dfs(x , adj , visited);
            }
        }
        return count ;
    }
    public boolean isGood(int V , int req ,ArrayList<ArrayList<Integer>> adj , boolean vis[] ){
        
        vis[V] = true ;
        ArrayList<Integer> edges = adj.get(V) ;
        if(edges.size() != req)return  false ;
        for(int nbr : edges){
            if(vis[nbr] == false){
                if(!isGood(nbr , req , adj , vis))return false ;
            }
        }
        return true ;
    }
}