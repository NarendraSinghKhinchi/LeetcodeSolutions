//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int n,int m, int[][] edges) {
		//Code here
		ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)list.add(new ArrayList<>());
        for(int ed[] : edges){
            list.get(ed[0]).add(new int[]{ed[1] , ed[2]});
        }
        int src = 0;
        int shortt[] = new int[n];
        Arrays.fill(shortt , Integer.MAX_VALUE);
        shortest(0 , list , shortt , new boolean[n] , 0);
        for(int i = 0 ; i < n ; i++)
            if(shortt[i] == Integer.MAX_VALUE)
                shortt[i] = -1 ;
                
        return shortt ;
	}
	public void shortest(int v ,ArrayList<ArrayList<int[]>>list ,int shortt[] , boolean vis[] , int dis  ){
	    if(vis[v])return ;
	    vis[v] = true ;
	    shortt[v] = Math.min(dis , shortt[v]);
	    
	    for(int x[] : list.get(v))
	        shortest(x[0] , list , shortt , vis , dis+x[1]);
	   
	   vis[v] = false ;
	}
}