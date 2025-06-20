//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long largestPrimeFactor(int N) {
        // code here
        int ans = 1 ;
        for(int i = 1 ;i <= Math.sqrt(N) ; i++){
            if(N % i == 0){
                int a = i ;
                int b = N/i ;
                if(isPrime(a))ans = Math.max(a , ans);
                if(isPrime(b))ans = Math.max(b , ans);
            }
        }
        return ans ;
    }
    static boolean isPrime(int N){
        
        for(int i = 2 ; i <= Math.sqrt(N) ; i++){
            if(N%i == 0)return false ;
        }
        return true ;
    }
}