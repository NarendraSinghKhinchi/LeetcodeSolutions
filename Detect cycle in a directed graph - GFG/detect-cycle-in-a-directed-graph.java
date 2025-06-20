//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int colors[] = new int[V];
        Arrays.fill(colors , 1);
        for(int i = 0 ; i < V ; i++){
            if(colors[i]==1 && dfs(colors , adj , i))return true ;
        }
        return false ;
    }
    public boolean dfs(int color[] , ArrayList<ArrayList<Integer>> adj , int v){
        if(color[v] == 2)return true ;
        if(color[v]==3)return false ;
        color[v] = 2 ;
        for(int x : adj.get(v)){
            if(dfs(color , adj , x))return true ;
        }
        color[v] = 3 ;
        return false ;
    }
}