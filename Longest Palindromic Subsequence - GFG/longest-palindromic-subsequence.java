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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String str)
    {
        //code here
        int n = str.length() ;
        String str2 = new StringBuilder(str).reverse().toString();
        int dp[][] = new int[str.length()+1][str.length()+1];
        
        for(int i = 1 ; i <= str.length() ; i++){
            for(int j = 1 ; j <= str.length() ; j++){
                char ch1 = str.charAt(i-1);
                char ch2 = str2.charAt(j-1);
                if(ch1 == ch2 ){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n][n] ;
    }
}