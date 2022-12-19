//{ Driver Code Starts
//Initial Template for Java

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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String s)
    {
        // code here
        if(s.charAt(0) - '0' == 0)return 0 ;
        int mod = (int)(1e9 + 7 );
        int dp[] = new int[s.length() + 1] ;
        dp[0] = 1 ;
        dp[1] = 1 ;
        for(int i = 2 ; i < dp.length ; i++){
            int ch = s.charAt(i-1) - '0' ;
            if(ch != 0){
               dp[i] = dp[i-1] ; 
            }
            int ch2 = s.charAt(i-2) - '0' ;
            if(ch2 == 1 || (ch2 == 2 && ch < 7)){
                dp[i] = (dp[i] + dp[i-2] )% mod ;
            }
        }
        return dp[s.length()] ;
    }
}