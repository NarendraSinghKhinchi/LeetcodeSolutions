//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        for(int i = 0 ; i < V ; i++){
            boolean visited[] = new boolean[V];
            ArrayList<Integer> list = new ArrayList<>();
            dfs(i , adj , visited , list);
            if(list.size()==V)return i ;
        }
        return -1;
    }
    public void dfs(int v , ArrayList<ArrayList<Integer>> adj , boolean visited[] , ArrayList<Integer> list){
        if(visited[v])return ;
        list.add(v);
        visited[v]=true;
        for(int x : adj.get(v)){
            dfs(x , adj , visited , list);
        }
    }
}