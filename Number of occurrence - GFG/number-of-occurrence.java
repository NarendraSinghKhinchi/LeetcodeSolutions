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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int low = 0 ;
        int high = n-1 ;
        int t = -1 ;
        while(low <= high){
            int mid = (low+high)/2 ;
            if(arr[mid] >= x){
                high = mid-1 ;
            }else{
                low = mid+1 ;
            }
            if(arr[mid] == x)t = mid ;
        }
        if(t == -1)return 0 ;
        
        low = 0 ;
        high = n-1 ;
        int ts = -1 ;
        while(low <= high){
            int mid = (low+high)/2 ;
            if(arr[mid] > x){
                high = mid-1 ;
            }else{
                low = mid+1 ;
            }
            if(arr[mid] == x)ts = mid ;
        }
        
        return (ts-t+1) ;
    }
    
}