//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int maxdis = stalls[n-1] - stalls[0] ;
        int mindis = 1 ;
        
        int ans = Integer.MIN_VALUE ;
        while(mindis <= maxdis){
            int dis = (mindis + maxdis)/2 ;
            boolean currans = false ;
            int currplacedcowidx = 0 ;
            int totalcows = k - 1 ;
            for(int i = 1 ; i < n ; i++){
                if(stalls[i] - stalls[currplacedcowidx] >= dis){
                    totalcows-- ;
                    currplacedcowidx = i ;
                    if(totalcows == 0){
                        currans = true ;
                        break ;
                    }
                }
            }
            if(currans){
                ans = Math.max(ans , dis) ;
                mindis = dis + 1 ;
            }else{
                maxdis = dis - 1;
            }
        }
        return ans ;
    }
}