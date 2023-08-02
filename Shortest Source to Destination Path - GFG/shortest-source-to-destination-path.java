//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        
        int steps = 0  ;
        int dirs[][] = new int[][]{{1,0} ,{0,1}, {-1,0} , {0 , -1}} ;
        while(!q.isEmpty()){
            int size = q.size() ;
            for(int i = 1 ; i<= size ; i++){
                int rem[] = q.remove();
                int r = rem[0] ;
                int c = rem[1] ;
                if(r == X && Y == c)return steps ;
                
                for(int dir[] : dirs){
                    int nr = r+dir[0] ;
                    int nc = c+dir[1] ;
                    
                    if(nr >= 0 && nc >= 0 && nr < N && nc < M && A[nr][nc] != 0){
                        q.add(new int[]{nr,nc});
                        A[nr][nc] = 0 ;
                    }
                }
            }
            steps++ ;
        }
        return -1 ;
    }
};