//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.subarrayCount(a,n,k);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int subarrayCount(int arr[], int N, int k) {
    // code here
        return atMost(arr, N, k)-atMost(arr, N, k-1) ;
    }
  private static int atMost(int[] nums, int n, int k) {
		int count = 0 ;
        int i = 0 ; 
        int j = 0 ;
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        while(j < nums.length){
            hm.put(nums[j] , hm.getOrDefault(nums[j] , 0) + 1) ;
            
            while(hm.size() > k){
                hm.put(nums[i], hm.get(nums[i]) - 1);
                if(hm.get(nums[i]) == 0)hm.remove(nums[i]) ;
                i++ ;
            }
            count += j-i+1 ;
            
            j++ ;
        }
        return count ;
	}
}