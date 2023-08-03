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

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int ans[] = new int[N] ;
		Arrays.fill(ans , -1);
		ArrayList<ArrayList<int[]>> list = new ArrayList<>();
		for(int i = 0 ; i < N ; i++)list.add(new ArrayList<>());
		for(int ed[] : edges){
		    list.get(ed[0]).add(new int[]{ed[1], ed[2]});
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{0,0,0});
		ans[0] = 0 ;
		while(!q.isEmpty()){
		    
		    int rem[] = q.remove();
		    int src = rem[0] ;
		    int dest = rem[1] ;
		    int wei = rem[2] ;
		    
		    for(int[] nbr : list.get(dest)){
		        int wt = nbr[1] ;
		        int de = nbr[0] ;
		        if(wt+wei <= ans[de] || ans[de] == -1){
		            q.add(new int[]{dest , de , wt+wei});
		            ans[de] = wt+wei ;
		        }
		        
		    }
		}
		
		return ans ;
	}
}