//{ Driver Code Starts
// Initial Template for Java

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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        int f = 0 ;
        int t = 0 ;
        for(int x : bills){
            if(x == 5)f += 1 ;
            if(x == 10){
                if(f > 0)f -=1 ;
                else return false ;
                t += 1 ;
            }
            
            if(x == 20){
                x -= 5 ;
                if(t > 0){
                    t -= 1 ;
                    x -= 10 ;
                }
                int req = x/5 ;
                if(f >= req)f -= req ;
                else return false ;
            }
        }
        return true ;
    }
}
