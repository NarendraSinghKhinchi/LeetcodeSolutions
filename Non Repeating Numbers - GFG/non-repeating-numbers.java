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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int xor = 0 ;
        for(int x : nums)xor ^= x ;
        
        // System.out.println(xor);
        
        int rmsb = (xor & (-xor)) ;
        
        int first = 0 ;
        int second = 0 ;
        
        for(int x : nums){
            if((rmsb & x )!= 0 ){
                first ^= x ;
            }else {
                second ^= x ;
            }
        }
        
        int arr[] = {first , second};
        Arrays.sort(arr);
        return arr ;
    }
}