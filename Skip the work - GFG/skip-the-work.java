//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minAmount(A,n));
                }
        }
}    
// } Driver Code Ends



class Solution
{
  public int minAmount(int A[] , int N)
    {
        //code here.
        int dp[][] = new int[N+1][2];
        for(int d[] : dp)Arrays.fill(d , 100000000) ;
        dp[1][0] = A[0] ; 
        // dp[0][0] = 0 ;
        dp[1][1] = 0 ;
        // dp[0][1] = 0 ;
        // System.out.println(dp[1][0] + "  " + dp[1][1] );
        for(int i = 2 ; i <= N ; i++){
            dp[i][0] = Math.min(dp[i-1][0] , dp[i-1][1]) + A[i-1] ;
            dp[i][1] = dp[i-1][0] ;
            // System.out.println(dp[i][0] + "  " + dp[i][1] );
        }
        
        return Math.min(dp[N][0] , dp[N][1]);
    }
}