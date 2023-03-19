//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        pq.add(new int[]{start , 0});
        int dis[] = new int[100000] ;
        
        Arrays.fill(dis , 1000001 );
        while(pq.isEmpty() == false){
            
            int rem[] = pq.remove();
            for(int x : arr){
                int next = (x*rem[0])%100000 ;
                if( rem[1] + 1 < dis[next]){
                    pq.add(new int[]{next , rem[1] + 1});
                    dis[next] = rem[1] + 1 ;
                }
            }
        }
        return dis[end] == 1000001 ? -1 : dis[end];
    }
}
