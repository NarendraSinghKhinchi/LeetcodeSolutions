//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[] = new int[n+1] ;
        Arrays.fill(dp,-1);
        return recurs(price , n , dp);
    }
    public int recurs(int price[] , int n , int dp[]){
        if(n == 0 )return 0 ;
        if(dp[n] != -1)return dp[n] ;
        int max = 0 ;
        for(int i = 0 ; i < price.length ; i++){
            if(n - (i + 1) < 0)break ;
            int curr = recurs(price , n-(i+1) , dp ) + price[i] ;
            max = Math.max(max , curr);
        }
        dp[n] = max ;
        // int nocut = recurs(price , n);
        return Math.max(max ,0);
    }
}