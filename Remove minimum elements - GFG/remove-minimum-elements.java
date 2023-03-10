//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().minRemoval(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    int minRemoval(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE ;
        for(int i = 0 ; i < arr.length ; i++){
            int dbl = arr[i]*2 ;
            // for(int j = i ; j < arr.length ; j++){
            //     if(arr[j] > dbl)break ;
            //     else{
            //         int curr = n - (j - i + 1);
            //         min = Math.min(curr , min);
            //     }
            // }
            int lo = i ;
            int hi = n-1 ;
            while(lo <= hi){
                int mid = lo + (hi-lo)/2 ;
                if(arr[mid] > dbl){
                    hi = mid-1 ;
                }else{
                    int curr = n - (mid - i + 1);
                    min = Math.min(curr , min);
                    lo = mid+1 ;
                }
            }
        }
        return min ;
    }
    
}