//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Solution ob = new Solution();
            System.out.println(
                ob.isItPossible(S[0], S[1], S[0].length(), S[1].length()));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    int isItPossible(String S, String T, int M, int N) {
        // code here
        if(M != N)return 0 ;
        int i = 0 ; 
        int j = 0 ;
        while(i < M && j < N){
            if(S.charAt(i) == '#'){
                i++ ;
            }else if(T.charAt(j) == '#'){
                j++ ;
            }else{
                if(S.charAt(i) != T.charAt(j))return 0 ;
                if(T.charAt(j) == 'B' && j < i )return 0 ;
                if(S.charAt(i) == 'A' && i < j)return  0 ;
                i++ ;
                j++ ;
            }
        }
        while(i < M){
            if(S.charAt(i) != '#')return 0 ;
            i++ ;
        }
        while(j < N){
            if(T.charAt(j) != '#')return 0 ;
            j++ ;
        }
        return 1 ;
    }
}