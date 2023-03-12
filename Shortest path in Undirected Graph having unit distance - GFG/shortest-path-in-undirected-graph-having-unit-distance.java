//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)list.add(new ArrayList<>());
        for(int ed[] : edges){
            list.get(ed[0]).add(ed[1]);
            list.get(ed[1]).add(ed[0]) ;
        }
        int shortt[] = new int[n];
        Arrays.fill(shortt , -1);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{src , 0});
        shortt[src] = 0 ;
        int level = 0   ;
        while(!q.isEmpty()){
            int size = q.size();
            while(size -- > 0){
                int rem[] = q.remove();
                shortt[rem[0]] = Math.min(rem[1] , shortt[rem[0]]);
                for(int x : list.get(rem[0])){
                    if(shortt[x] == -1){
                        q.add(new int[]{x , rem[1]+1});
                        shortt[x] = Integer.MAX_VALUE ;
                    }
                }
            }
            
            level++ ;
        }
        return shortt ;
    }
}