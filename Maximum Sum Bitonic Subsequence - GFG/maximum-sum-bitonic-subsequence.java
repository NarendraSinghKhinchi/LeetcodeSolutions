//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java



class Compute {
    
    public static int maxSumBS(int nums[], int n)
    {
        int lis[] = new int[nums.length];
        for(int i = 0 ; i < lis.length ; i++){
            lis[i] = nums[i] ;
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    lis[i] = Math.max(lis[i] , lis[j]+nums[i]);
                }
            }
        }
        int lds[] = new int[nums.length];
        for(int i = lds.length - 1 ; i >= 0 ; i--){
            lds[i] = nums[i] ;
            for(int j = nums.length-1 ; j > i ; j--){
                if(nums[i] > nums[j]){
                    lds[i] = Math.max(lds[i] , lds[j]+nums[i]);
                }
            }
        }
        int max = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max , lis[i]+lds[i]-nums[i]);
        }
        return max ;
    }
}