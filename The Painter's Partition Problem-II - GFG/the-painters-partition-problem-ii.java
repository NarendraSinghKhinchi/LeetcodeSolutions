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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        long sum = 0 ;
        for(int x : arr)sum += x ;
        long lo = 0 ; 
        long hi  = sum ;
        long ans = -1 ;
        while(lo <= hi){
            long mid = lo + (hi-lo)/2 ;
            boolean bool = possible(arr , k , mid);
            if(bool){
                ans = mid ;
                hi = mid-1 ;
            }else lo = mid+1 ;
        }
        return ans ;
    }
    static boolean possible(int []arr , int k , long time){
        int curr = 1 ;
        long sum  = 0l ;
        for(int x : arr){
            if(sum + x <= time)sum += x ;
            else {
                sum = x ;
                curr += 1 ;
            }
            if(x > time)return false ;
            if(curr > k)return false ;
        }
        return true ;
    }
}


