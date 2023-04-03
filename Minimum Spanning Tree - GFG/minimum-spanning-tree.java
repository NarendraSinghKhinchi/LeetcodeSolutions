//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<ArrayList<Integer>>> list = new ArrayList<>();
	    for(int i = 0 ; i < V ; i++){
	        list.add(new ArrayList<>());
	    }
	    for(int edge[] : edges){
	        ArrayList<Integer> clist = new ArrayList<>();
	        clist.add(edge[1]);
	        clist.add(edge[2]);
	        list.get(edge[0]).add(clist);
	        ArrayList<Integer> clist2 = new ArrayList<>();
	        clist2.add(edge[0]);
	        clist2.add(edge[2]);
	        list.get(edge[1]).add(clist2);
	    }
	   // System.out.println(list);
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.wt-y.wt);
	    pq.add(new Pair(0 , 0));
	    int sum = 0 ;
	    boolean visited[] = new boolean[V];
	    
	    while(pq.isEmpty() == false){
	        Pair rem = pq.remove();
	        if(visited[rem.node])continue ;
	        visited[rem.node] = true ;
	        sum += rem.wt ;
	        
	        for(ArrayList<Integer> nbrs : list.get(rem.node)){
	            if(visited[nbrs.get(0)] == false)
	                pq.add(new Pair(nbrs.get(1) , nbrs.get(0)));
	        }
	    }
	    return sum ;
	}
	static class Pair{
	    int node , wt ;
	    Pair(int wt , int nor){
	        this.node = nor ;
	        this.wt  = wt ;
	    }
	}
}






























