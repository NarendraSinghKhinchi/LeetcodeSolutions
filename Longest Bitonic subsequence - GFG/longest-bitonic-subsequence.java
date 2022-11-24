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
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int lis[] = new int[nums.length];
        for(int i = 0 ; i < lis.length ; i++){
            int lo = 0 ;
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    lo = Math.max(lo , lis[j]);
                }
            }
            lis[i] = lo+1 ;
        }
        int lds[] = new int[nums.length];
        for(int i = lds.length - 1 ; i >= 0 ; i--){
            int lo = 0;
            for(int j = nums.length-1 ; j > i ; j--){
                if(nums[i] > nums[j]){
                    lo = Math.max(lo , lds[j]);
                }
            }
            lds[i] = lo + 1;
        }
        int max = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max , lis[i]+lds[i]-1);
        }
        return max ;
    }
}