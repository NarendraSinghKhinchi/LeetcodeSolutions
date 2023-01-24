//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int N, int arr[]){
        // Code here
        int dp[] = new int[N];
        int marr[] = new int[N] ;
        int maxi = 0 ;
        for(int i = 0 ; i < N ; i++){
            int max = -1 ;
            for(int j = 0 ; j < i ; j++){
                if(arr[i] > arr[j] && (max == -1 || dp[max] < dp[j] ))
                    max = j ;
            }
            if(max == -1){
                dp[i] = 1  ;
                marr[i] = i;
            }else{
                dp[i] = dp[max]+1 ;
                marr[i] = max ;
            }
            if(dp[maxi] < dp[i])maxi = i ;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(maxi >= 0){
            list.add(arr[maxi]);
            if(maxi == marr[maxi])break;
            maxi = marr[maxi];
        }
        
        Collections.reverse(list);
        return list ;
    }
}
